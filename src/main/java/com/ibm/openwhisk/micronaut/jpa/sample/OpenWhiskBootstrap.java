package com.ibm.openwhisk.micronaut.jpa.sample;

import com.google.gson.JsonObject;
import io.micronaut.context.ApplicationContext;
import io.micronaut.runtime.Micronaut;

public class OpenWhiskBootstrap {

    public static void main(String[] args) throws Exception{

        System.out.println("OpenWhisk Micronaut command line runner");
        // eventually we will want to parse the args to this CL call
        // get the json from a params arg and construct a JsonObject
        // to pass to the main call to the BaseOWFunction
        JsonObject jsonArgs = new JsonObject();
        JsonObject result = main(jsonArgs, OpenWhiskBootstrap.class.getClassLoader());
        System.out.println("Result:" +result);

    }

    public static JsonObject main(JsonObject args, ClassLoader cl)  {
        String[] args1 = {};
        ApplicationContext ac = Micronaut.build(args1).classes(BaseOWFunction.class, GenreRepositoryImpl.class, javax.persistence.EntityManager.class).classLoader(cl).start();
//        JsonObject response = new JsonObject();
        BaseOWFunction bow = ac.getBean(BaseOWFunction.class);
        JsonObject response = bow.execute(args);
        return response;
    }
}
