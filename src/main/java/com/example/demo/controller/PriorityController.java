package com.example.demo.controller;

import com.example.demo.entity.Cathegory;
import com.example.demo.entity.Priority;
import com.example.demo.service.CathegoryService;
import com.example.demo.service.PriorityService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "priority/")
@AllArgsConstructor
public class PriorityController {

    private final PriorityService priorityService;

    @GetMapping(path = "/all")
    public List<Priority> getAllPriorities(){
        return priorityService.getAllPriorities();
    }

    @GetMapping(path = "/{id}")
    public Priority getPriorityById(@PathVariable("id") Long id){
        return priorityService.getPriorityById(id);
    }

    @GetMapping(path = "/byName/{name}")
    public Priority getPriorityByName(@PathVariable("name") String name){
        return priorityService.getPriorityByName(name);
    }

    @PostMapping(path = "/add")
    public void addNewPriority(@RequestBody Priority priority){
        priorityService.addNewPriority(priority);
    }

    @PutMapping(path = "/update")
    public void updatePriority(@RequestBody Priority priority){
        priorityService.updatePriority(priority.getId(), priority.getName());
    }

    @DeleteMapping(path = "/delete/{id}")
    public void deletePriority(@PathVariable("id") Long id){
        priorityService.deletePriority(id);
    }
}
