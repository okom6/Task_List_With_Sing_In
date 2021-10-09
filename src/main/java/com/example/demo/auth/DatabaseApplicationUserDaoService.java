package com.example.demo.auth;

import com.example.demo.entity.AppUser;
import com.example.demo.service.AppUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Repository;

import java.util.*;

@Repository("database")
public class DatabaseApplicationUserDaoService implements ApplicationUserDao{

    private final AppUserService appUserService;
    private final PasswordEncoder passwordEncoder;

    private List<ApplicationUser> applicationUsers = new ArrayList<>();

    @Autowired
    public DatabaseApplicationUserDaoService(AppUserService appUserService, PasswordEncoder passwordEncoder) {
        this.appUserService = appUserService;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public Optional<ApplicationUser> selectApplicationUserByUsername(String username) {
        Optional<ApplicationUser> applicationUserOptional = applicationUsers
                .stream()
                .filter(applicationUser -> username.equals(applicationUser.getUsername()))
                .findFirst();

        if(!applicationUserOptional.isPresent()){
            addUserToListFromDatabase(username);

            applicationUserOptional = applicationUsers
                    .stream()
                    .filter(applicationUserStream -> username.equals(applicationUserStream.getUsername()))
                    .findFirst();
        }

        return applicationUserOptional;
    }

    private void addUserToListFromDatabase(String username){
        Set<SimpleGrantedAuthority> simpleGrantedAuthorities = new HashSet<>();

        AppUser appUser = appUserService.getAppUserByUsername(username);

        ApplicationUser applicationUser = new ApplicationUser(
                appUser.getUsername(),
                passwordEncoder.encode(appUser.getPassword()),
                simpleGrantedAuthorities,
                true,
                true,
                true,
                true
        );

        applicationUsers.add(applicationUser);
    }

    @Bean
    public void addAdminToDatabase(){
        appUserService.addNewAppUser(new AppUser("admin", "1234"));
    }
}
