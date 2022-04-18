package org.ac.cst8277.heggie.brandon.userservice.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserForDisplay {

    private Long id;
    private String name;
    private String email;
    private Date created;
    private Date lastVisited;

}
