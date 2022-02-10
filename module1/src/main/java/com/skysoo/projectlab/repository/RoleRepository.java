package com.skysoo.projectlab.repository;

import com.skysoo.projectlab.domain.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleRepository extends JpaRepository<Role, Integer> {
    Role findByMemberId(int MemberId);
}
