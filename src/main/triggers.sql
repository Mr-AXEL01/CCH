DROP TRIGGER IF EXISTS trigger_calculate_position ON results;
DROP FUNCTION IF EXISTS calculate_rider_position();

CREATE
OR REPLACE FUNCTION calculate_rider_position()
    RETURNS TRIGGER AS
$$
BEGIN

    IF
(TG_OP = 'INSERT') THEN

UPDATE results
SET rank = rank + 1
WHERE stage_id = NEW.stage_id
  AND time
    > NEW.time;

SELECT COUNT(*) + 1
INTO NEW.rank
FROM results
WHERE stage_id = NEW.stage_id
  AND time
    < NEW.time;

RETURN NEW;
END IF;

    IF
(TG_OP = 'UPDATE') THEN
        IF NEW.time IS DISTINCT FROM OLD.time THEN

UPDATE results
SET rank = null
WHERE stage_id = NEW.stage_id
  AND cyclist_id = NEW.cyclist_id;

UPDATE results
SET rank = subq.new_pos FROM (
                     SELECT cyclist_id,
                            ROW_NUMBER() OVER (ORDER BY time) as new_pos
                     FROM results
                     WHERE stage_id = NEW.stage_id
                       AND cyclist_id != NEW.cyclist_id
                 ) as subq
WHERE results.stage_id = NEW.stage_id
  AND results.cyclist_id = subq.cyclist_id;

SELECT COUNT(*) + 1
INTO NEW.rank
FROM results
WHERE stage_id = NEW.stage_id
  AND time
    < NEW.time;
END IF;

RETURN NEW;
END IF;

    IF
(TG_OP = 'DELETE') THEN

UPDATE results
SET rank = rank - 1
WHERE stage_id = OLD.stage_id
  AND rank > OLD.rank;

RETURN OLD;
END IF;

RETURN NULL;
END;
$$
LANGUAGE plpgsql;


CREATE TRIGGER trigger_calculate_position
    BEFORE INSERT OR
UPDATE OR
DELETE
ON results
    FOR EACH ROW
    EXECUTE FUNCTION calculate_rider_position();


--------------------- GeneralResults trigger -------------------------------


DROP TRIGGER IF EXISTS stage_closure_trigger ON stages;

CREATE
OR REPLACE FUNCTION handle_stage_closure()
    RETURNS TRIGGER AS
$$
BEGIN

    IF
NEW.closed = true AND OLD.closed = false THEN

UPDATE general_results gr
SET general_time = (SELECT SUM(sr.time)
                    FROM results sr
                             JOIN stages s ON sr.stage_id = s.id
                    WHERE sr.cyclist_id = gr.cyclist_id
                      AND s.competition_id = gr.competition_id
                      AND s.closed = true)
WHERE gr.competition_id = NEW.competition_id
  AND gr.cyclist_id IN (SELECT sr.cyclist_id
                        FROM results sr
                                 JOIN stages s ON sr.stage_id = s.id
                        WHERE s.competition_id = NEW.competition_id
                          AND s.closed = true);

UPDATE general_results gr1
SET general_rank = (SELECT COUNT(*)
                    FROM general_results gr2
                    WHERE gr2.competition_id = gr1.competition_id
                      AND gr2.general_time <= gr1.general_time)
WHERE gr1.competition_id = NEW.competition_id;
END IF;

RETURN NEW;
END;
$$
LANGUAGE plpgsql;

CREATE TRIGGER stage_closure_trigger
    AFTER UPDATE OF closed
    ON stages
    FOR EACH ROW
    EXECUTE FUNCTION handle_stage_closure();
