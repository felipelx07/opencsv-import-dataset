package com.softplan.challenge.factory;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.context.RequestScoped;
import javax.enterprise.inject.Produces;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.io.Serializable;

@ApplicationScoped
public class EntityManagerFactory implements Serializable {

    private static final long serialVersionUID = 1L;

    @PersistenceContext(unitName = "softplan-challenge-unit")
    private EntityManager em;

    @Produces
    @RequestScoped
    public EntityManager produceEntityManager() {
        return em;
    }
}
