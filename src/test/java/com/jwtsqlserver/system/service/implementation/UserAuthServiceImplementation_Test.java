package com.jwtsqlserver.system.service.implementation;

import com.jwtsqlserver.system.model.UserAuth;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Optional;

@RunWith(SpringRunner.class)
@SpringBootTest
public class UserAuthServiceImplementation_Test {

    @Autowired
    UserAuthServiceImplementation userAuthServiceImplementation;

    @Test
    void getUserAuthByUsername(){
        String username = "eperez";
        System.out.println(username);
        Optional<UserAuth> userAuthOptional =  userAuthServiceImplementation.getUserAuthByUsername(username);
    }
}
