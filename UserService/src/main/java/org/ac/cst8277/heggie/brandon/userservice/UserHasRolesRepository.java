package org.ac.cst8277.heggie.brandon.userservice;

import org.ac.cst8277.heggie.brandon.userservice.entity.UserHasRoles;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface UserHasRolesRepository extends JpaRepository<UserHasRoles, Long> {

    UserHasRoles findUserHasRolesByUserId(Long userId);
}
