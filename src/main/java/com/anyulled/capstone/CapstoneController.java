package com.anyulled.capstone;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Controller.
 */
@RestController
public class CapstoneController {

    /**
     * Say hello function.
     *
     * @return my name
     */
    @GetMapping("/")
    public String sayHello() {
        return "Hello Udacity! my name is Anyul Rivas";
    }
}
