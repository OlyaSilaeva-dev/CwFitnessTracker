package com.database.fitnessTracker.controller;

import com.database.fitnessTracker.entity.Users;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/user")
@RequiredArgsConstructor
public class UserController {

    @GetMapping("/info")
    @ResponseBody
    public ResponseEntity<Users> currentUser() {
        Users currentUser = (Users) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        return ResponseEntity.ok(currentUser);
    }

}
