package com.docker.postgresql.service.user;

import com.docker.postgresql.entity.user.User;
import com.docker.postgresql.repository.user.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * Service to manage {@link User} object
 */
@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepository userRepository;

    /**
     * @see UserService#allUsers() for more information
     */
    @Override
    public List<User> allUsers() {
        return userRepository.findAll();
    }

    /**
     * @see UserService#edit(User) for more information
     */
    @Override
    public User edit(User users) {
        User entitySaved;
        Optional<User> optionalUser = userRepository.findById(users.getId());
        if (optionalUser.isPresent()) {
            User entity = optionalUser.get();
            entity.setRole(users.getRole());
            entitySaved = userRepository.save(entity);
        } else {
            entitySaved = userRepository.save(users);
        }
        return entitySaved;
    }

    /**
     * @see UserService#search(String) for more information
     */
    @Override
    public List<User> search(String value) {
        return userRepository.search("%" + value + "%");
    }

    /**
     * @see UserService#findById(long) for more information
     */
    @Override
    public User findById(long id) throws UnknownUserException {
        return userRepository.findById(id).orElseThrow(() -> new UnknownUserException(id));
    }

    /**
     * @see UserService#findByEmail(String)
     */
    @Override
    public List<User> findByEmail(String email) {
        return userRepository.findByEmail(email);
    }
}
