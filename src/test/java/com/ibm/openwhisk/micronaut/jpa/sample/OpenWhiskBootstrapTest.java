package com.ibm.openwhisk.micronaut.jpa.sample;

import com.google.gson.JsonObject;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class OpenWhiskBootstrapTest {

    @Test
    void main() throws  Exception{

        System.out.println("Does this do something?");

        JsonObject args = new JsonObject();
        args.addProperty("name", "TestValue");
//        JsonObject response = OpenWhiskBootstrap.main(args, OpenWhiskBootstrapTest.class.getClassLoader());
//        assertNotNull(response);
//        String greetings = response.getAsJsonPrimitive("greetings").getAsString();
//        assertNotNull(greetings);
//        assertEquals("Hello! Welcome to OpenWhisk", greetings);
    }
}
