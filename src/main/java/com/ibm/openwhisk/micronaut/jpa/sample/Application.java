package com.ibm.openwhisk.micronaut.jpa.sample;

import io.micronaut.runtime.Micronaut;

public class Application {

    public static void main(String[] args) {
        System.out.println("Command line runner");
        Micronaut.run(Application.class);
    }
}
