package org.ac.cst8277.heggie.brandon.messageservice.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;


@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Subscription {

    @Id
    private Long producerID;
    private Long subscriberID;

}
