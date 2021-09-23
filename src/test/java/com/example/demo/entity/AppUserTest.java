package com.example.demo.entity;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class AppUserTest {

    @Test
    public void createdAppUserSuccessfullWithNoArgsConstructor(){
        AppUser appUser = new AppUser();

        appUser.setUsername("username");

        assertEquals("username", appUser.getUsername());
    }

    @Test
    public void createdAppUserSuccessfullWithConstructorWithUsernameAndPassword(){
        AppUser appUser = new AppUser(
                "username",
                "password");

        assertEquals("username", appUser.getUsername());
        assertEquals("password", appUser.getPassword());
    }

    @Test
    public void createdAppUserSuccessfullWithAllArgsConstructor(){
        List<Task> taskList = new ArrayList<>();

        AppUser appUser = new AppUser(
                1L,
                "username",
                "password",
                taskList);

        assertEquals(1L, appUser.getId());
        assertEquals("username", appUser.getUsername());
        assertEquals("password", appUser.getPassword());
        assertEquals(taskList, appUser.getTaskList());
    }
}
