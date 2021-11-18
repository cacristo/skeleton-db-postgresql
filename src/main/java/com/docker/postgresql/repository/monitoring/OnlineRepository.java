package com.docker.postgresql.repository.monitoring;

import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Repository
public class OnlineRepository {
    @PersistenceContext
    private EntityManager entityManager;

    public boolean isOnline() {
        return (boolean) entityManager.createNativeQuery("Select true as boolean").getSingleResult();
    }
}