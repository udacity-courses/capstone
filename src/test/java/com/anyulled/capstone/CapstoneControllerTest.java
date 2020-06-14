package com.anyulled.capstone;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

class CapstoneControllerTest {

    CapstoneController capstoneController = new CapstoneController();

    @Test
    void sayHello() {
        System.setProperty("CAPSTONE_ENVIRONMENT", "test");
        Assertions.assertThat(capstoneController.sayHello())
                .as("Testing the controller is throwing the proper default message")
                .isEqualTo("Hello Udacity! my name is Anyul Rivas. null");
    }
}