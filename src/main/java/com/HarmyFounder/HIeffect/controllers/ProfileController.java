package com.HarmyFounder.HIeffect.controllers;

import com.HarmyFounder.HIeffect.models.User;
import com.HarmyFounder.HIeffect.repositories.UserDetailRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProfileController {

    @Autowired
    private UserDetailRepo userDetailRepo;

    @GetMapping("/usr}")
    public User getProfile(@AuthenticationPrincipal User user){
        return user;
    }

}
