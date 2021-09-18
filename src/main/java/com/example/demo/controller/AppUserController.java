package com.example.demo.controller;

import com.example.demo.entity.AppUser;
import com.example.demo.entity.Priority;
import com.example.demo.service.AppUserService;
import com.example.demo.service.PriorityService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "user/")
@AllArgsConstructor
public class AppUserController {

    private final AppUserService appUserService;

    @GetMapping(path = "/all")
    public List<AppUser> getAllAppUsers(){
        return appUserService.getAllAppUsers();
    }

    @GetMapping(path = "/{id}")
    public AppUser getAppUserById(@PathVariable("id") Long id){
        return appUserService.getAppUserById(id);
    }

    @GetMapping(path = "/byUsername/{username}")
    public AppUser getAppUserByUsername(@PathVariable("username") String username){
        return appUserService.getAppUserByUsername(username);
    }

    @PostMapping(path = "/add")
    public void addNewAppUser(@RequestBody AppUser appUser){
        appUserService.addNewAppUser(appUser);
    }

    @PutMapping(path = "/update")
    public void updateAppUser(@RequestBody AppUser appUser){
        appUserService.updateAppUser(appUser);
    }

    @DeleteMapping(path = "/delete/{id}")
    public void deleteAppUser(@PathVariable("id") Long id){
        appUserService.deleteAppUser(id);
    }
}
