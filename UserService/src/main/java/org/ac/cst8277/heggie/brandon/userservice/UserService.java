package org.ac.cst8277.heggie.brandon.userservice;

import org.ac.cst8277.heggie.brandon.userservice.entity.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private UserHasRolesRepository userHasRolesRepository;
    @Autowired
    private RolesRepositorty rolesRepositorty;

    public void createUser(User user) {
        User foundUser = userRepository.findUserByEmail(user.getEmail());
        if(foundUser == null){
            User newUser = new User();
            newUser.setEmail(user.getEmail());
            newUser.setName(user.getName());
            newUser.setPassword(user.getPassword());
            newUser.setCreated(new Date());
            newUser.setLastVisited(new Date());
            userRepository.save(user);
        }
    }

    public String login(LoginTemplate login) {
        User foundUser = userRepository.findUserByEmailAndPassword(login.getEmail(), login.getPassword());
        if (foundUser != null){
            UUID key = UUID.randomUUID();
            foundUser.setUuid(key.toString());
            userRepository.save(foundUser);
            return key.toString();
        }
        else {
            return null;
        }
    }

    public User getByUUID(String key) {
        return userRepository.findUserByUuid(key);
    }

    public Long getRoleById(Long userId) {
        UserHasRoles userHasRoles = userHasRolesRepository.findUserHasRolesByUserId(userId);
        return userHasRoles.getRoleId();
    }

    public List<UserForDisplay> getAllUsers() {
        List<User> users =  userRepository.findAll();
        List<UserForDisplay> displayList = new ArrayList<>();
        for(User u : users){
            displayList.add(new UserForDisplay(u.getId(),u.getName(),u.getEmail(),u.getCreated(),u.getLastVisited()));
        }
        return displayList;
    }

    public List<Role> getAllRoles() {
        return rolesRepositorty.findAll();
    }
}
