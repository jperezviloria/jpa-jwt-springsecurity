package com.jwtsqlserver.system.service.implementation;

import com.jwtsqlserver.system.model.UserAuth;
import com.jwtsqlserver.system.repository.UserAuthRepository;
import com.jwtsqlserver.system.service.UserAuthServer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserAuthServiceImplementation implements UserAuthServer {

    @Autowired
    UserAuthRepository userAuthRepository;


    @Override
    public List<UserAuth> getAllUserAuth() {
        return userAuthRepository.findAll();
    }

    @Override
    public Optional<UserAuth> getUserAuthByUsername(String username) {
        return userAuthRepository.getUserAuthByUsername(username);
    }

    @Override
    public String saveUserAuth(UserAuth userAuth) {
        userAuthRepository.save(userAuth);
        return "SAVED";
    }
}
