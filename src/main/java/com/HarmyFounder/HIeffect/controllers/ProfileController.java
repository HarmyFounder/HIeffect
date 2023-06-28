package com.HarmyFounder.HIeffect.controllers;

import com.HarmyFounder.HIeffect.models.User;
import com.HarmyFounder.HIeffect.repositories.UserDetailRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProfileController {

    @Autowired
    private UserDetailRepo userDetailRepo;

    @GetMapping("/{id}}")
    public User getProfile(@PathVariable("id") User user){
        return user;
    }

}
