package com.example.demo.entity;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CathegoryTest {

    @Test
    public void createdCathegorySuccessfullWithNoArgsConstructor(){
        Cathegory cathegory = new Cathegory();

        cathegory.setName("name");

        assertEquals("name", cathegory.getName());
    }

    @Test
    public void createdCathegorySuccessfullWithConstructorWithName(){
        Cathegory cathegory = new Cathegory("name");

        assertEquals("name", cathegory.getName());
    }

    @Test
    public void createdCathegorySuccessfullWithAllArgsConstructor(){
        List<Task> taskList = new ArrayList<>();
        Cathegory cathegory = new Cathegory(
                1L,
                "name",
                taskList);

        assertEquals(1L, cathegory.getId());
        assertEquals("name", cathegory.getName());
        assertEquals(taskList, cathegory.getTasks());
    }
}
