package com.docker.postgresql.utilities.jpa;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.time.LocalDateTime;

/**
 * Abstract Class for Entity without Id definition
 */
@MappedSuperclass
@EntityListeners({CustomEntityListener.class})
public abstract class AbstractSimpleEntity<ID> implements SimpleEntity<ID> {
    @Version
    @Column(nullable = false)
    private long version;

    @Column(updatable = false)
    @Convert(converter = LocalDateTimeConverter.class)
    private LocalDateTime creationDate;

    @Column(updatable = false)
    private String creationUser;

    @Column
    @Convert(converter = LocalDateTimeConverter.class)
    private LocalDateTime lastUpdateDate;

    @Column
    private String lastUpdateUser;

    public AbstractSimpleEntity() {
    }

    public abstract ID getId();

    public abstract void setId(ID id);

    public long getVersion() {
        return this.version;
    }

    public void setVersion(long version) {
        this.version = version;
    }

    public LocalDateTime getCreationDate() {
        return this.creationDate;
    }

    public void setCreationDate(LocalDateTime creationDate) {
        this.creationDate = creationDate;
    }

    public String getCreationUser() {
        return this.creationUser;
    }

    public void setCreationUser(String creationUser) {
        this.creationUser = creationUser;
    }

    public LocalDateTime getLastUpdateDate() {
        return this.lastUpdateDate;
    }

    public void setLastUpdateDate(LocalDateTime lastUpdateDate) {
        this.lastUpdateDate = lastUpdateDate;
    }

    public String getLastUpdateUser() {
        return this.lastUpdateUser;
    }

    public void setLastUpdateUser(String lastUpdateUser) {
        this.lastUpdateUser = lastUpdateUser;
    }

    @JsonIgnore
    public boolean isNew() {
        return this.getId() == null || (this.getId() instanceof Long && (Long) this.getId() == 0L);
    }

    @JsonIgnore
    public boolean isNotNew() {
        return !this.isNew();
    }

}
