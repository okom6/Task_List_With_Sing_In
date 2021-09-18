package com.example.demo.controller;

import com.example.demo.entity.Priority;
import com.example.demo.entity.Task;
import com.example.demo.service.PriorityService;
import com.example.demo.service.TaskService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "task/")
@AllArgsConstructor
public class TaskController {

    private final TaskService taskService;

    @GetMapping(path = "/all")
    public List<Task> getAllTasks(){
        return taskService.getAllTasks();
    }

    @GetMapping(path = "/{id}")
    public Task getTaskById(@PathVariable("id") Long id){
        return taskService.getTaskById(id);
    }

    @PostMapping(path = "/add/{appUserId}/{cathegoryId}/{priorityId}")
    public void addNewTask(@RequestBody Task task,
                           @PathVariable("appUserId") Long appUserId,
                           @PathVariable("cathegoryId") Long cathegoryId,
                           @PathVariable("priorityId") Long priorityId){
        taskService.addNewTask(
                task.getText(),
                appUserId,
                cathegoryId,
                priorityId
        );
    }

    @PutMapping(path = "/update/{taskId}/{appUserId}/{cathegoryId}/{priorityId}")
    public void updateTask(@RequestBody Task task,
                               @PathVariable("taskId") Long taskId,
                               @PathVariable("appUserId") Long appUserId,
                               @PathVariable("cathegoryId") Long cathegoryId,
                               @PathVariable("priorityId") Long priorityId){
        taskService.updateTask(
                taskId,
                task.getText(),
                appUserId,
                cathegoryId,
                priorityId
        );
    }

    @DeleteMapping(path = "/delete/{id}")
    public void deleteTask(@PathVariable("id") Long id){
        taskService.deleteTask(id);
    }
}
