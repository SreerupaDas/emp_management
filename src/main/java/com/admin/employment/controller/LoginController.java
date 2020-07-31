package com.admin.employment.controller;

import com.admin.employment.dto.ErrorMessageDTO;
import com.admin.employment.dto.LoginDTO;
import com.admin.employment.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LoginController {
    @Autowired
    private LoginService loginService;

    @PostMapping("/login")
    public ResponseEntity loginUser(@RequestBody LoginDTO loginDTO) {
        if(!loginService.login(loginDTO)) {
            return ResponseEntity
                    .status(HttpStatus.UNAUTHORIZED)
                    .body(new ErrorMessageDTO("Invalid username or password provided."));
        }
        return ResponseEntity.ok(true);
    }
}
