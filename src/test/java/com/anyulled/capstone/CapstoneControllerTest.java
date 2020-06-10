package com.anyulled.capstone;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class CapstoneControllerTest {

    CapstoneController capstoneController = new CapstoneController();

    @Test
    void sayHello() {
        assertEquals(capstoneController.sayHello(), "Hello Udacity! my name is Anyul Rivas");
    }
}