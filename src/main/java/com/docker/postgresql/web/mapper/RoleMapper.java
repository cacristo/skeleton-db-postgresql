package com.docker.postgresql.web.mapper;

import com.docker.postgresql.entity.user.Role;
import com.docker.postgresql.web.dto.RoleDTO;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Generic mapper used by {@link Role}/{@link RoleDTO}
 */
@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface RoleMapper {

    /**
     * Mapping {@link RoleDTO} to {@link Role} directly.
     *
     * @param dto {@link RoleDTO}
     * @return {@link Role}
     */
    Role toEntity(RoleDTO dto);

    /**
     * Mapping {@link Role} to {@link RoleDTO} directly.
     *
     * @param role {@link Role}
     * @return {@link RoleDTO}
     */
    RoleDTO toDTO(Role role);


    default List<RoleDTO> toDTOList(List<Role> roleList) {
        if (roleList == null) {
            return new ArrayList<>();
        }
        return roleList.stream().map(this::toDTO).collect(Collectors.toList());
    }

    default List<Role> toEntityList(List<RoleDTO> roleDTOList) {
        if (roleDTOList == null) {
            return new ArrayList<>();
        }
        return roleDTOList.stream().map(this::toEntity).collect(Collectors.toList());
    }
}