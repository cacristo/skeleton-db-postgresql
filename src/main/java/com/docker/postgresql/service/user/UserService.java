package com.docker.postgresql.service.user;

import com.docker.postgresql.entity.user.User;

import java.util.List;

public interface UserService {
    /**
     * List of all users available.
     *
     * @return {@link List <User>}
     */
    List<User> allUsers();

    User edit(User entity);

    /**
     * List of all users founded.
     *
     * @param value filtre
     * @return {@link List <User>}
     */
    List<User> search(String value);

    /**
     * Find user by Id
     * @param id User id
     * @return {@link User}
     * @throws UnknownUserException If user Id is not found
     */
    User findById(long id) throws UnknownUserException ;
    /**
     * Find user by Email
     * @param email
     * @return
     */
    List<User> findByEmail(String email);
}
