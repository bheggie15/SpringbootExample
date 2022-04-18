package org.ac.cst8277.heggie.brandon.userservice;

import org.ac.cst8277.heggie.brandon.userservice.entity.User;
import org.ac.cst8277.heggie.brandon.userservice.entity.UserForDisplay;
import org.hibernate.annotations.Type;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    User findUserByEmailAndPassword(String email, String password);

    User findUserByEmail(String email);


    User findUserByUuid(String key);
}
