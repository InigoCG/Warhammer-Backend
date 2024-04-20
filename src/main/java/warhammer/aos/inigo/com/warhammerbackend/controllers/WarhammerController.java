package warhammer.aos.inigo.com.warhammerbackend.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class WarhammerController {

    @GetMapping("/")
    public static ResponseEntity<String> test() {
        return new ResponseEntity<>("Hola Mundo!", HttpStatus.OK);
    }

}
