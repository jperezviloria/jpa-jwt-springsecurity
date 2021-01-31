package com.jwtsqlserver.system.service;

import com.jwtsqlserver.system.model.UserAuth;

import java.util.List;
import java.util.Optional;

public interface UserAuthServer {

    List<UserAuth> getAllUserAuth();

    Optional<UserAuth> getUserAuthByUsername(String username);

    String saveUserAuth(UserAuth userAuth);
}
