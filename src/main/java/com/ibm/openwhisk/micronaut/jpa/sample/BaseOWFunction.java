package com.ibm.openwhisk.micronaut.jpa.sample;

import com.google.gson.JsonObject;
import io.micronaut.context.annotation.Context;

import javax.inject.Inject;
import javax.inject.Singleton;

@Context
@Singleton
public class BaseOWFunction {

    @Inject
    SomeService someService;

    @Inject
    GenreRepository genreRepository;

    public JsonObject execute(JsonObject args) {
        JsonObject response = new JsonObject();
        System.out.println("BaseOWFunction.execute");
        System.out.println("someService.getSomething()" + someService.getSomething());
        someService.getSomething();
        Genre savedObject = genreRepository.save("Micronaut Genre");
        response.addProperty("Genre", savedObject.toString());
        return response;
    }
}
