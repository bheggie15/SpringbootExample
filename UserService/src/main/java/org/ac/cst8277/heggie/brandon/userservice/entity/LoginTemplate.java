package org.ac.cst8277.heggie.brandon.userservice.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class LoginTemplate {

    private String email;
    private String password;
}
