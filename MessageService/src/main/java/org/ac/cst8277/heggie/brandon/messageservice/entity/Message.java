package org.ac.cst8277.heggie.brandon.messageservice.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Message {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long messageID;
    private Long userID;
    private String content;
    private Date timestamp;

    public Message(String content) {
        this.content = content;
    }
}
