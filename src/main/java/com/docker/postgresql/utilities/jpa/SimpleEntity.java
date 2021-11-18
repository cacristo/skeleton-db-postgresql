package com.docker.postgresql.utilities.jpa;

import java.time.LocalDateTime;

public interface SimpleEntity<ID> {

    ID getId();

    void setId(ID var1);

    long getVersion();

    void setVersion(long var1);

    LocalDateTime getCreationDate();

    void setCreationDate(LocalDateTime var1);

    String getCreationUser();

    void setCreationUser(String var1);

    LocalDateTime getLastUpdateDate();

    void setLastUpdateDate(LocalDateTime var1);

    String getLastUpdateUser();

    void setLastUpdateUser(String var1);
}
