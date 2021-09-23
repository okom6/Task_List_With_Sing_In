package com.example.demo.entity;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PriorityTest {

    @Test
    public void createdPrioritySuccessfullWithNoArgsConstructor(){
        Priority priority = new Priority();

        priority.setName("name");

        assertEquals("name", priority.getName());
    }

    @Test
    public void createdPrioritySuccessfullWithConstructorWithName(){
        Priority priority = new Priority("name");

        assertEquals("name", priority.getName());
    }

    @Test
    public void createdPrioritySuccessfullWithAllArgsConstructor(){
        List<Task> taskList = new ArrayList<>();
        Priority priority = new Priority(
                1L,
                "name",
                taskList);

        assertEquals(1L, priority.getId());
        assertEquals("name", priority.getName());
        assertEquals(taskList, priority.getTasks());
    }
}
