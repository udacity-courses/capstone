package com.anyulled.capstone;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import static java.lang.String.format;

/**
 * Controller.
 */
@RestController
public class CapstoneController {

    @Value("${CAPSTONE_ENVIRONMENT:testEnvironment}")
    private String environment;

    /**
     * Say hello function.
     *
     * @return my name
     */
    @GetMapping("/")
    public String sayHello() {
        return format("Hello Udacity! my name is Anyul Rivas. %s", environment);
    }
}
