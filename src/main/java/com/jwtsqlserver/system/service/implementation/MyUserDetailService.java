package com.jwtsqlserver.system.service.implementation;

import com.jwtsqlserver.system.model.MyUserDetails;
import com.jwtsqlserver.system.model.UserAuth;
import com.jwtsqlserver.system.repository.UserAuthRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Optional;

@Service
public class MyUserDetailService  implements UserDetailsService {

    @Autowired
    UserAuthRepository userAuthRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        Optional<UserAuth> user = userAuthRepository.getUserAuthByUsername(username);
        user.orElseThrow(() -> new UsernameNotFoundException("Not found: " + username));

        return user.map(MyUserDetails::new).get();
        //return new User("foo","foo", new ArrayList<>());
    }
}