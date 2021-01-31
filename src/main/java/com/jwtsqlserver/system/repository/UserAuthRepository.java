package com.jwtsqlserver.system.repository;

import com.jwtsqlserver.system.model.UserAuth;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserAuthRepository extends JpaRepository<UserAuth, String> {

    @Query(value = "SELECT * FROM userAuth", nativeQuery = true)
    List<UserAuth> getAllUserAuthQuery();


    //@Query(value = "SELECT * FROM userAuth WHERE username = ?1", nativeQuery = true)
    @Query(value = "EXEC getUserAuthByUsername @username = ?1", nativeQuery = true)
    Optional<UserAuth> getUserAuthByUsername(String username);


}
