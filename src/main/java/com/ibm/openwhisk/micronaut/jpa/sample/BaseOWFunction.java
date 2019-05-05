package com.ibm.openwhisk.micronaut.jpa.sample;

import com.google.gson.JsonObject;

import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
public class BaseOWFunction {

    @Inject
    GenreRepository genreRepository;

    public JsonObject execute(JsonObject args) {
        JsonObject response = new JsonObject();
        System.out.println("BaseOWFunction.execute");
        Genre savedObject = genreRepository.save("Micronaut Genre");
        response.addProperty("Genre", savedObject.toString());
        return response;
    }
}
