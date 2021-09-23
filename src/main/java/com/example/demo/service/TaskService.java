package com.example.demo.service;

import com.example.demo.entity.AppUser;
import com.example.demo.entity.Cathegory;
import com.example.demo.entity.Priority;
import com.example.demo.entity.Task;
import com.example.demo.repository.AppUserRepository;
import com.example.demo.repository.CathegoryRepository;
import com.example.demo.repository.PriorityRepository;
import com.example.demo.repository.TaskRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class TaskService {
    private final TaskRepository taskRepository;
    private final AppUserRepository appUserRepository;
    private final CathegoryRepository cathegoryRepository;
    private final PriorityRepository priorityRepository;

    public List<Task> getAllTasks(){
        return taskRepository.findAll();
    }

    public Task getTaskById(Long id){
        Task task = taskRepository.findById(id)
                .orElseThrow(() ->  new IllegalStateException(
                        String.format("Task with id %s not found", id)));
        return task;
    }

    public void addNewTask(String text,
                           Long appUserId,
                           Long cathegoryId,
                           Long priorityId){

        AppUser appUser = appUserRepository.findById(appUserId)
                .orElseThrow(() ->  new IllegalStateException(
                        String.format("AppUser with id %s not found", appUserId)));

        Cathegory cathegory = cathegoryRepository.findById(cathegoryId)
                .orElseThrow(() ->  new IllegalStateException(
                        String.format("Cathegory with id %s not found", cathegoryId)));

        Priority priority = priorityRepository.findById(priorityId)
                .orElseThrow(() ->  new IllegalStateException(
                        String.format("Priority with id %s not found", priorityId)));

        Task task = new Task(priority, cathegory, appUser, text);
        taskRepository.save(task);
    }

    public void updateTask(Long taskId,
                           String text,
                           Long appUserId,
                           Long cathegoryId,
                           Long priorityId){

        Task task = taskRepository.findById(taskId)
                .orElseThrow(() ->  new IllegalStateException(
                        String.format("Task with id %s not found", taskId)));

        AppUser appUser = appUserRepository.findById(appUserId)
                .orElseThrow(() ->  new IllegalStateException(
                        String.format("AppUser with id %s not found", appUserId)));

        Cathegory cathegory = cathegoryRepository.findById(cathegoryId)
                .orElseThrow(() ->  new IllegalStateException(
                        String.format("Cathegory with id %s not found", cathegoryId)));

        Priority priority = priorityRepository.findById(priorityId)
                .orElseThrow(() ->  new IllegalStateException(
                        String.format("Priority with id %s not found", priorityId)));

        task.setAppUser(appUser);
        task.setCathegory(cathegory);
        task.setPriority(priority);
        task.setText(text);
        taskRepository.save(task);
    }

    public void deleteTask(Long id){
        Task task = taskRepository.findById(id)
                .orElseThrow(() ->  new IllegalStateException(
                        String.format("Task with id %s not found", id)));
        taskRepository.delete(task);
    }
}
