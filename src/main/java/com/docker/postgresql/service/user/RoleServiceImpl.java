package com.docker.postgresql.service.user;

import com.docker.postgresql.entity.user.Role;
import com.docker.postgresql.repository.user.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Service to manage {@link Role} object
 */
@Service
public class RoleServiceImpl implements RoleService {

    @Autowired
    private RoleRepository roleRepository;

    /**
     * @see RoleService#allRoles() for more information
     */
    @Override
    public List<Role> allRoles() {
        return roleRepository.findAll();
    }
}
