package com.docker.postgresql.web.mapper;

import com.docker.postgresql.entity.user.User;
import com.docker.postgresql.web.dto.UserDTO;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Generic mapper used by {@link User}/{@link UserDTO}
 */
@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface UserMapper {

    /**
     * Mapping {@link UserDTO} to {@link User} directly.
     *
     * @param dto {@link UserDTO}
     * @return {@link User}
     */
    User toEntity(UserDTO dto);

    /**
     * Mapping {@link User} to {@link UserDTO} directly.
     *
     * @param user {@link User}
     * @return {@link UserDTO}
     */
    UserDTO toDTO(User user);


    default List<UserDTO> toDTOList(List<User> userList) {
        if (userList == null) {
            return new ArrayList<>();
        }
        return userList.stream().map(this::toDTO).collect(Collectors.toList());
    }

    default List<User> toEntityList(List<UserDTO> userDTOList) {
        if (userDTOList == null) {
            return new ArrayList<>();
        }
        return userDTOList.stream().map(this::toEntity).collect(Collectors.toList());
    }
}