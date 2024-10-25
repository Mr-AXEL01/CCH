package net.axel.controllers;

import net.axel.exceptions.CustomException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/custom")
public class CustomController {

    @GetMapping
    public ResponseEntity<String> hey() {
        throw new CustomException("here is the error from controller");
    }
}
