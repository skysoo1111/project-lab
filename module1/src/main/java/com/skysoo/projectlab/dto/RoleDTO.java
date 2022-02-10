package com.skysoo.projectlab.dto;

import com.skysoo.projectlab.domain.Member;
import com.skysoo.projectlab.domain.Role;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@Getter
@Builder
@NoArgsConstructor(force = true)
@AllArgsConstructor
public class RoleDTO {
    private final Integer id;
    private final String role;
    private final Integer memberId;

    public static List<RoleDTO> from(Collection<Role> roles) {
        return roles.stream().map(RoleDTO::from).collect(Collectors.toList());
    }

    public static RoleDTO from(Role roleEntity) {
        return RoleDTO.builder()
                .id(roleEntity.getId())
                .role(roleEntity.getRole())
                .memberId(roleEntity.getId())
                .build();
    }


}
