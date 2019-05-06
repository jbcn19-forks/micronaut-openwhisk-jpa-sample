package com.ibm.openwhisk.micronaut.jpa.sample;

import com.google.gson.JsonObject;
import io.micronaut.context.annotation.Context;
import io.micronaut.context.annotation.Property;
import io.micronaut.context.env.Environment;
import io.micronaut.context.env.yaml.YamlPropertySourceLoader;

import javax.inject.Inject;
import javax.inject.Singleton;
import java.net.URL;
import java.net.URLClassLoader;
import java.security.Timestamp;
import java.time.ZonedDateTime;

@Context
@Singleton
public class BaseOWFunction {

    @Inject
    SomeService someService;

    @Property(name = "datasources.default.name")
    String propertyName;

    @Inject
    Environment env;

    @Inject
    GenreRepository genreRepository;

    public JsonObject execute(JsonObject args) {
        JsonObject response = new JsonObject();

        Genre savedObject = genreRepository.save("Micronaut Genre "+ ZonedDateTime.now().toInstant().toEpochMilli());
        response.addProperty("Genre", savedObject.toString());

        return response;
    }
}
