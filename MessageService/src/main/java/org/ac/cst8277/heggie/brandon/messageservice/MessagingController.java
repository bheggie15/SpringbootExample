package org.ac.cst8277.heggie.brandon.messageservice;

import org.ac.cst8277.heggie.brandon.messageservice.entity.Message;
import org.ac.cst8277.heggie.brandon.messageservice.VO.MessageRequest;
import org.springframework.context.annotation.Lazy;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping(path =  "/message")
public class MessagingController {

    private final MessagingService messagingService;


    public MessagingController(@Lazy MessagingService messagingService){
        this.messagingService = messagingService;
    }

    @PostMapping
    public ResponseEntity<String> makePost (@RequestBody MessageRequest message){
        return messagingService.makePost(message);
    }
    @GetMapping
    public List<Message> getMessages(){
        return messagingService.getAllMessages();
    }

    @GetMapping("/feed/{id}")
    public List<Message> getFeedForUser (@PathVariable Long id){
        return messagingService.getFeed(id);
    }
    @GetMapping("/{id}")
    public List<Message> getAllMessagesByUser(@PathVariable Long id){
        return messagingService.getAllMessages(id);
    }
}
