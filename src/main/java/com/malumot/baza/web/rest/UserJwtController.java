package com.malumot.baza.web.rest;

import com.malumot.baza.domain.User;
import com.malumot.baza.repository.UserRepository;
import com.malumot.baza.security.JwtTokenProvider;
import com.malumot.baza.web.rest.vn.LoginVM;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api")
public class UserJwtController {

    private final AuthenticationManager authenticationManager;

    private final JwtTokenProvider jwtTokenProvider;

    private final UserRepository userRepository;

    public UserJwtController(AuthenticationManager authenticationManager, JwtTokenProvider jwtTokenProvider, UserRepository userRepository) {
        this.authenticationManager = authenticationManager;
        this.jwtTokenProvider = jwtTokenProvider;
        this.userRepository = userRepository;
    }

    @PostMapping("/login")
    public ResponseEntity login(@RequestBody LoginVM loginVM){
        authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(loginVM.getUserName(), loginVM.getPassword()));
        User user = userRepository.findByLogin(loginVM.getUserName());
        if (user == null){
            throw new UsernameNotFoundException("Bunday foydalanuvchi yoq");
        }
        String token = jwtTokenProvider.createToken(user.getUserName(), user.getRoles());
        Map<Object, Object> map = new HashMap<>();
        map.put("username", user.getUserName());
        map.put("token", token);
        return ResponseEntity.ok(map);
    }

}
