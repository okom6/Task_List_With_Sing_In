package com.example.demo.auth;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Repository;

import java.util.*;

@Repository("fake")
public class FakeApplicationUserDaoService implements ApplicationUserDao{

    private final PasswordEncoder passwordEncoder;

    @Autowired
    public FakeApplicationUserDaoService(PasswordEncoder passwordEncoder) {
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public Optional<ApplicationUser> selectApplicationUserByUsername(String username) {
        return getApplicationUsers()
                .stream()
                .filter(applicationUser -> username.equals(applicationUser.getUsername()))
                .findFirst();
    }

    private List<ApplicationUser> getApplicationUsers(){
        List<ApplicationUser> applicationUsers = new ArrayList<>();
        Set<SimpleGrantedAuthority> simpleGrantedAuthorities = new HashSet<>();
        applicationUsers.add(
                new ApplicationUser(
                        "annasmith",
                        passwordEncoder.encode("1234"),
                        simpleGrantedAuthorities,
                        true,
                        true,
                        true,
                        true
                )
        );
        applicationUsers.add(
                new ApplicationUser(
                        "linda",
                        passwordEncoder.encode("1234"),
                        simpleGrantedAuthorities,
                        true,
                        true,
                        true,
                        true
                )
        );
        applicationUsers.add(
                new ApplicationUser(
                        "tom",
                        passwordEncoder.encode("1234"),
                        simpleGrantedAuthorities,
                        true,
                        true,
                        true,
                        true
                )
        );

        return applicationUsers;
    }
}
