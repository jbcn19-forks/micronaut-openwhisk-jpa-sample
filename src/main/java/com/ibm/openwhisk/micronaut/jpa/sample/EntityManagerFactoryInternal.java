package com.ibm.openwhisk.micronaut.jpa.sample;

import javax.inject.Singleton;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

@Singleton
public class EntityManagerFactoryInternal {


    public static EntityManager getEntityManager() {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("LOCAL_PERSISTENCE");
        return emf.createEntityManager();
    }


}
