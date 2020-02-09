package com.cloud.ribbon.controller;

import com.cloud.ribbon.entity.user;
import com.cloud.ribbon.service.UserService;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;
import java.util.Optional;

@RestController
public class UserController {
    @Autowired
    private UserService userService;
    @RequestMapping(value = "/user/{id}")
    public user getUser(@PathVariable("id") Long u_id) throws JsonProcessingException {
        return userService.getUser(u_id);
    }
    //login----Требующие авторизацию
    @RequestMapping(value = "/login",method = RequestMethod.POST)
    public user getUserByName(@RequestParam("u_name") String u_name,@RequestParam("u_password")String u_password) throws JsonProcessingException {
        user user=new user();
        user.setU_name(u_name);
        user.setU_password(u_password);
        return userService.getUserByName(user);
    }
}
