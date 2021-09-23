package com.example.demo.service;

import com.example.demo.entity.AppUser;
import com.example.demo.entity.Priority;
import com.example.demo.repository.AppUserRepository;
import com.example.demo.repository.PriorityRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
@Slf4j
public class AppUserService {

    private final AppUserRepository appUserRepository;

    public List<AppUser> getAllAppUsers(){
        return appUserRepository.findAll();
    }

    public AppUser getAppUserById(Long id){
        AppUser appUser = appUserRepository.findById(id)
                .orElseThrow(() ->  new IllegalStateException(
                        String.format("AppUser with id %s not found", id)));
        return appUser;
    }

    public AppUser getAppUserByUsername(String username){
        AppUser appUser = appUserRepository.findAppUserByUsername(username)
                .orElseThrow(() ->  new IllegalStateException(
                        String.format("AppUser with username %s not found", username)));
        return appUser;
    }

    public void addNewAppUser(AppUser appUser){
        String hashedPassword = getHashedPassword(appUser.getPassword());

        AppUser newAppUser = new AppUser(
                appUser.getUsername(),
                hashedPassword
        );
        appUserRepository.save(newAppUser);
    }

    public void updateAppUser(AppUser updatedAppUser){
        AppUser appUser = appUserRepository.findById(updatedAppUser.getId())
                .orElseThrow(() ->  new IllegalStateException(
                        String.format("AppUser with id %s not found", updatedAppUser.getId())));
        if(updatedAppUser.getUsername() != null){
            appUser.setUsername(updatedAppUser.getUsername());
        }
        if(updatedAppUser.getPassword() != null){
            String hashedPassword = getHashedPassword(updatedAppUser.getPassword());

            appUser.setPassword(hashedPassword);
        }
        appUserRepository.save(appUser);
    }

    public void deleteAppUser(Long id){
        AppUser appUser = appUserRepository.findById(id)
                .orElseThrow(() ->  new IllegalStateException(
                        String.format("AppUser with id %s not found", id)));
        appUserRepository.delete(appUser);
    }

    private String getHashedPassword(String password){
        return password; //TODO: Implement method
    }
}
