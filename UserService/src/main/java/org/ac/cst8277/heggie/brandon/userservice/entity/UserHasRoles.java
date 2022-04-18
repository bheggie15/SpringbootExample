package org.ac.cst8277.heggie.brandon.userservice.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserHasRoles {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long userHasRolesId;
    private Long userId;
    private Long roleId;}
