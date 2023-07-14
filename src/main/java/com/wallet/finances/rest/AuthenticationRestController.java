package com.wallet.finances.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.wallet.finances.entities.user.AuthResponseDTO;
import com.wallet.finances.entities.user.LoginDTO;
import com.wallet.finances.entities.user.RegisterDTO;
import com.wallet.finances.entities.user.User;
import com.wallet.finances.entities.user.UserRole;
import com.wallet.finances.services.UserService;

@RestController
@RequestMapping("/auth")
public class AuthenticationRestController {

    @Autowired
    private UserService userService;

    @PostMapping("/login")
    public AuthResponseDTO login(@RequestBody LoginDTO data){
        String token = userService.login(data.login(), data.password());

        return new AuthResponseDTO("ok", "User logged succefully!", token);
    }

    @PostMapping("/register")
    public AuthResponseDTO register(@RequestBody RegisterDTO data){
        User newUser = new User(0L, data.name(), data.username(), data.email(), data.password(), UserRole.USER);
        String token = userService.register(newUser);

        return new AuthResponseDTO("ok", "User registered succefully!", token);
    }
}
