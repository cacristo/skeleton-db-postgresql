package com.docker.postgresql.web.webservice;

import com.docker.postgresql.service.user.RoleService;
import com.docker.postgresql.service.user.UnknownUserException;
import com.docker.postgresql.service.user.UserService;
import com.docker.postgresql.web.dto.RoleDTO;
import com.docker.postgresql.web.dto.UserDTO;
import com.docker.postgresql.web.mapper.RoleMapper;
import com.docker.postgresql.web.mapper.UserMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Web Service responsible to users/roles.
 */
@RestController
@RequestMapping(value = "/users")
public class UsersWS {
    private static final Logger LOG = LoggerFactory.getLogger(UsersWS.class);

    @Autowired
    private UserService userService;
    @Autowired
    private RoleService roleService;
    @Autowired
    private UserMapper userMapper;
    @Autowired
    private RoleMapper roleMapper;

    @GetMapping(value = "/roles")
    public List<RoleDTO> getAllRoles() {
        LOG.info("UsersWS.getAllRoles - GET '/uses/roles'");
        return roleMapper.toDTOList(roleService.allRoles());
    }

    @GetMapping
    public List<UserDTO> getAllUsers() {
        LOG.info("UsersWS.getAllUsers - GET '/users'");
        return userMapper.toDTOList(userService.allUsers());
    }

    @PutMapping(value = "/{id}")
    public UserDTO editUser(@PathVariable long id,
                            @RequestBody UserDTO userDTO) {
        LOG.info("UsersWS.editUser - PUT '/users/id'");
        userDTO.setId(id);
        return userMapper.toDTO(userService.edit(userMapper.toEntity(userDTO)));
    }

    @GetMapping(value = "/search")
    public List<UserDTO> searchUsers(@RequestParam String filtre) {
        String info = String.format("GET /users/search?filtre=%s", filtre);
        LOG.info("UsersWS.searchUsers {}", info);
        return userMapper.toDTOList(userService.search(filtre));
    }

    @GetMapping(value = "/{id}")
    public UserDTO findById(@PathVariable long id) throws UnknownUserException {
        String info = String.format("GET /users/%s", id);
        LOG.info("UsersWS.findById {}", info);
        return userMapper.toDTO(userService.findById(id));
    }
}
