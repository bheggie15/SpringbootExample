package org.ac.cst8277.heggie.brandon.messageservice.VO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Type;

import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class MessageRequest {

    private String content;
 //   @Type(type = "org.hibernate.type.UUIDCharType")
    private String key;



}
