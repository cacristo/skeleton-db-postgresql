package com.docker.postgresql.repository.user;

import com.docker.postgresql.entity.user.Role;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Repository use only for the entity {@link Role}
 */
public interface RoleRepository extends JpaRepository<Role, String> {
}
