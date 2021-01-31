package com.jwtsqlserver.system.controller;

import com.jwtsqlserver.system.model.AuthenticationResponse;
import com.jwtsqlserver.system.model.UserAuth;
import com.jwtsqlserver.system.service.implementation.MyUserDetailService;
import com.jwtsqlserver.system.service.implementation.UserAuthServiceImplementation;
import com.jwtsqlserver.system.util.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("login")
public class UserAuthController {

    @Autowired
    UserAuthServiceImplementation userAuthServiceImplementation;

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private MyUserDetailService userDetailService;

    @Autowired
    private JwtUtil jwtTokenUtil;


    @GetMapping
    public List<UserAuth> getAllUserAuth(){
        return userAuthServiceImplementation.getAllUserAuth();
    }

    @GetMapping("/verifing")
    public Optional<UserAuth> getUSerAuthByUsername(@RequestBody String username){
        return userAuthServiceImplementation.getUserAuthByUsername(username);
    }

    @PostMapping
    public String saveUserAuth(@RequestBody UserAuth userAuth){
        return userAuthServiceImplementation.saveUserAuth(userAuth);
    }

    @PostMapping("/authenticate")
    public ResponseEntity<?> createAuthenticationToken(@RequestBody UserAuth userAuth)throws Exception{
        System.out.println("Hola");
        try {
            authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(userAuth.getUsername(), userAuth.getPassword())
            );
        } catch (BadCredentialsException e){
            throw new Exception("Incorrect username or password", e);
        }
        final UserDetails userDetails = userDetailService
                .loadUserByUsername(userAuth.getUsername());
        final String jwt = jwtTokenUtil.generateToken(userDetails);

        return ResponseEntity.ok(new AuthenticationResponse(jwt));
    }

}
