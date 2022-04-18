package org.ac.cst8277.heggie.brandon.messageservice;
import org.ac.cst8277.heggie.brandon.messageservice.VO.User;
import org.ac.cst8277.heggie.brandon.messageservice.entity.Message;
import org.ac.cst8277.heggie.brandon.messageservice.VO.MessageRequest;
import org.ac.cst8277.heggie.brandon.messageservice.entity.Subscription;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

@Service
public class MessagingService {
    @Autowired
    private MessageRepository messageRepository;
    @Autowired
    private SubscriptionRepository subscriptionRepository;
    @Autowired
    private RestTemplate restTemplate;


    public List<Message> getAllMessages() {
        return messageRepository.findAll();
    }
    public List<Message> getAllMessages(Long id) {
        return messageRepository.findAllByUserID(id);
    }

    public ResponseEntity<String> makePost(MessageRequest message) {
        if(authenticateKey(message.getKey())){
            User user = getUserFromKey(message.getKey());
            if (getRoleId(user.getId())==3){
                Message newMessage = new Message();
                newMessage.setContent(message.getContent());
                newMessage.setUserID(user.getId());
                newMessage.setTimestamp(new Date());
                messageRepository.save(newMessage);
                return new ResponseEntity<>("Message created successfully", HttpStatus.OK);
            }
            else{
                return new ResponseEntity<>("Invalid permissions. Not authorized to post a message.",HttpStatus.UNAUTHORIZED);
            }
        }
        else{
            return new ResponseEntity<>("Invalid key. Post login at /login to receive valid key.",HttpStatus.UNAUTHORIZED);
        }
    }

    public List<Message> getFeed(Long id) {
            List<Subscription> subscriptions = subscriptionRepository.findSubscriptionsBySubscriberID(id);
            List<Message> messageFeed = new ArrayList<>();
            for (Subscription s:subscriptions) {
                messageFeed.addAll(messageRepository.findAllByUserID(s.getProducerID()));
            }
            return messageFeed;

    }

    private boolean authenticateKey (String key){
        User user = restTemplate.getForObject("http://localhost:8080/user/" +key, User.class);
        if (user != null){
            return true;
        }
        else {
            return false;
        }
    }
    private User getUserFromKey(String key){
        return restTemplate.getForObject("http://localhost:8080/user/" +key, User.class);
    }
    private Long getRoleId(Long id){
            return restTemplate.getForObject("http://localhost:8080/user/role/"+id, Long.class);

    }
}