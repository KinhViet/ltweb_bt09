package home.controller;

import home.entity.UserInfo;
import home.service.UserInfoDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
public class UserController {
    
    @Autowired
    private UserInfoDetailService service;
    
    @PostMapping("/new")
    public String addUser(@RequestBody UserInfo userInfo) {
        return service.addUser(userInfo);
    }
}