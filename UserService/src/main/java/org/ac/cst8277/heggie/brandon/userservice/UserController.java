package org.ac.cst8277.heggie.brandon.userservice;

import org.ac.cst8277.heggie.brandon.userservice.entity.LoginTemplate;
import org.ac.cst8277.heggie.brandon.userservice.entity.Role;
import org.ac.cst8277.heggie.brandon.userservice.entity.User;
import org.ac.cst8277.heggie.brandon.userservice.entity.UserForDisplay;
import org.hibernate.annotations.Type;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/user")
public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/{key}")
    public User validateUser(@PathVariable("key") String key){return userService.getByUUID(key);}
    @PutMapping
    public void createUser(@RequestBody User user){
        userService.createUser(user);
    }
    @PostMapping
    public String login (@RequestBody LoginTemplate login){
        return userService.login(login);
    }
    @GetMapping("/all")
    public List<UserForDisplay> getAllUsers(){
        return userService.getAllUsers();
    }
    @GetMapping("/role/{id}")
    public Long checkUserRole(@PathVariable("id") Long userId){return userService.getRoleById(userId);}
    @GetMapping("/role")
    public List<Role> getAllRoles(){
        return userService.getAllRoles();
    }
}
