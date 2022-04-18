package org.ac.cst8277.heggie.brandon.userservice;

import org.ac.cst8277.heggie.brandon.userservice.entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RolesRepositorty extends JpaRepository<Role, Long> {
}
