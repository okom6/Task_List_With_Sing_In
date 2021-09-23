package com.example.demo.entity;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TaskTest {

    @Test
    public void createdTaskSuccessfullWithNoArgsConstructor(){
        Task task = new Task();

        task.setText("text");

        assertEquals("text", task.getText());
    }

    @Test
    public void createdTaskSuccessfullWithConstructorWithText(){
        Task task = new Task("text");

        assertEquals("text", task.getText());
    }

    @Test
    public void createdTaskSuccessfullWithConstructorWithPriorityCathegoryAppuserAndText(){
        Priority priority = new Priority();
        Cathegory cathegory = new Cathegory();
        AppUser appUser = new AppUser();
        Task task = new Task(
                priority,
                cathegory,
                appUser,
                "text");
        
        assertEquals(priority, task.getPriority());
        assertEquals(cathegory, task.getCathegory());
        assertEquals(appUser, task.getAppUser());
        assertEquals("text", task.getText());
    }

    @Test
    public void createdPrioritySuccessfullWithAllArgsConstructor(){
        Priority priority = new Priority();
        Cathegory cathegory = new Cathegory();
        AppUser appUser = new AppUser();
        Task task = new Task(
                1L,
                priority,
                cathegory,
                appUser,
                "text");

        assertEquals(1L, task.getId());
        assertEquals(priority, task.getPriority());
        assertEquals(cathegory, task.getCathegory());
        assertEquals(appUser, task.getAppUser());
        assertEquals("text", task.getText());
    }
}
