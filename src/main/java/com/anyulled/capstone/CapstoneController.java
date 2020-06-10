package com.anyulled.capstone;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CapstoneController {

    @GetMapping("/")
    public String sayHello() {
        return "Hello Udacity! my name is Anyul Rivas";
    }
}
