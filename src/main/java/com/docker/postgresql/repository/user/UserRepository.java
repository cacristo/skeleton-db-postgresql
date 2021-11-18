package com.docker.postgresql.repository.user;

import com.docker.postgresql.entity.user.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

/**
 * Repository use only for the entity {@link User}
 */
public interface UserRepository extends JpaRepository<User, Long> {
    @Query("FROM User WHERE upper(nom) LIKE upper(:value)"
            + " or upper(prenom) LIKE upper(:value)"
            + " or upper(email) LIKE upper(:value)"
            + " or upper(telephone) LIKE upper(:value)"
            + " or upper(activite) LIKE upper(:value)"
            + " or upper(role.code) LIKE upper(:value)")
    List<User> search(@Param("value") String value);

    /**
     * Returns all users with the given email. This method will be translated into a
     * query using the one declared in the {@link Query} annotation declared one.
     *
     * @param email
     * @return
     */
    @Query("select u from User u where u.email = :email")
    List<User> findByEmail(String email);
}
