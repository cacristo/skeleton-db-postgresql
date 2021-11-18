package com.docker.postgresql.utilities.jpa;

import com.docker.postgresql.utilities.date.DateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;

/**
 * Update audit fields for all Entities
 */
@Component
public class CustomEntityListener {

    private static DateService dateService;

    @Autowired
    public void setDateService(DateService dateService) {
        CustomEntityListener.dateService = dateService;
    }

    @PreUpdate
    public void preUpdate(SimpleEntity entity) {
        entity.setLastUpdateDate(dateService.now());
        entity.setLastUpdateUser(findUsername());
    }

    @PrePersist
    public void prePersist(SimpleEntity entity) {
        entity.setCreationDate(dateService.now());
        entity.setLastUpdateDate(dateService.now());

        final String userName = findUsername();
        entity.setCreationUser(userName);
        entity.setLastUpdateUser(userName);
    }

    private String findUsername() {
        return "Anonymous";
    }
}
