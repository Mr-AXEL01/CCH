package net.axel;

import net.axel.config.PersistenceConfig;
import net.axel.domains.entities.Cyclist;
import net.axel.services.interfaces.ICyclistService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

public class Main {
    public static void main(String[] args) {

        ApplicationContext context = new AnnotationConfigApplicationContext(PersistenceConfig.class);

        ICyclistService cyclistService = context.getBean(ICyclistService.class);

        Cyclist newCyclist = new Cyclist();
        newCyclist.setFirstName("aymen");
        newCyclist.setLastName("el maini");
        newCyclist.setAge(LocalDate.of(2004, 10, 27));
        newCyclist.setNationality("Moroccan");

        Cyclist savedCyclist = cyclistService.saveCyclist(newCyclist);
        System.out.println("Saved Cyclist: " + savedCyclist.getFirstName() + ", Age: " + savedCyclist.getAge());

        List<Cyclist> cyclists = cyclistService.getAllCyclists();
        System.out.println("\nList of all Cyclists:");
        cyclists.forEach(cyclist ->
                System.out.println("ID: " + cyclist.getId() + ", Name: " + cyclist.getFirstName() + ", Age: " + cyclist.getAge())
        );

        UUID cyclistId = savedCyclist.getId();
        Cyclist cyclistById = cyclistService.getCyclistById(cyclistId);
        if (cyclistById != null) {
            System.out.println("\nCyclist found by ID: " + cyclistById.getFirstName());
        } else {
            System.out.println("\nCyclist not found by ID.");
        }
//
//        cyclistService.deleteCyclist(cyclistId);
//        System.out.println("\nCyclist with ID " + cyclistId + " has been deleted.");

        Cyclist deletedCyclist = cyclistService.getCyclistById(cyclistId);
        if (deletedCyclist == null) {
            System.out.println("\nCyclist deletion confirmed.");
        } else {
            System.out.println("\nCyclist still exists in the database.");
        }
    }
}
