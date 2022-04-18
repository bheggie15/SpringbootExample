package org.ac.cst8277.heggie.brandon.messageservice;



import org.ac.cst8277.heggie.brandon.messageservice.entity.Message;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MessageRepository extends JpaRepository<Message, Long> {

    List<Message> findAllByUserID (Long userID);
}
