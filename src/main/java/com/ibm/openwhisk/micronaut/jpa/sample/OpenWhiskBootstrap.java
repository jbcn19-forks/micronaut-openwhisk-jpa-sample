package com.ibm.openwhisk.micronaut.jpa.sample;

import com.google.gson.JsonObject;
import io.micronaut.context.ApplicationContext;
import io.micronaut.context.env.yaml.YamlPropertySourceLoader;
import io.micronaut.runtime.Micronaut;

import javax.persistence.EntityManager;
import java.net.URL;
import java.net.URLClassLoader;

public class OpenWhiskBootstrap {

    public static ApplicationContext retrievedAC = null;

    public static void main(String[] args) throws Exception {

        System.out.println("OpenWhisk Micronaut command line runner");
        // eventually we will want to parse the args to this CL call
        // get the json from a params arg and construct a JsonObject
        // to pass to the main call to the BaseOWFunction
        JsonObject jsonArgs = new JsonObject();
        JsonObject result = main(jsonArgs, OpenWhiskBootstrap.class.getClassLoader());
        System.out.println("Result:" + result);

    }

    public static JsonObject main(JsonObject args, ClassLoader cl) throws Exception {
        ApplicationContext ac;
        if (retrievedAC == null) {
            String[] args1 = {};
            EntityManager em = EntityManagerFactoryInternal.getEntityManager();
            ac = Micronaut.build(args1).classes(BaseOWFunction.class).classLoader(cl).propertySources().singletons(em).start();
            retrievedAC = ac;
        } else {
            ac = retrievedAC;
        }
        BaseOWFunction bow = ac.getBean(BaseOWFunction.class);
        JsonObject response = bow.execute(args);

        return response;
    }

    public void dumpDebugInfo() {
        ClassLoader cl = this.getClass().getClassLoader();
        URL[] urls = ((URLClassLoader)cl).getURLs();

        for(URL url: urls){
            System.out.println(url.getFile());
        }

        System.out.println("CL application.yml:" + cl.getResource("application.yml"));
        System.out.println("cl.getParent(): " +cl.getParent());
        try {
            Class c = Class.forName("io.micronaut.configuration.hibernate.jpa.EntityManagerFactoryBean");
            System.out.println("Class.forName:" + c);
            System.out.println("Class.forName:" + c.getClassLoader());
            System.out.println("Class.forName:" + c.getClassLoader().getParent());
        } catch (Exception e) {
            System.out.println("problem in Class.forName");
            e.printStackTrace();
        }
    }
}
