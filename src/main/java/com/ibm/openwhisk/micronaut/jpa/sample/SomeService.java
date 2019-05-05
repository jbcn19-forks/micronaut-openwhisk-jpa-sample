package com.ibm.openwhisk.micronaut.jpa.sample;

import javax.inject.Singleton;

@Singleton
public class SomeService {

    public String getSomething() {
        return "something";
    }
}
