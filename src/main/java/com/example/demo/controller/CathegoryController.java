package com.example.demo.controller;

import com.example.demo.entity.AppUser;
import com.example.demo.entity.Cathegory;
import com.example.demo.service.CathegoryService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping(path = "/cathegory")
@AllArgsConstructor
public class CathegoryController {

    private final CathegoryService cathegoryService;

    @GetMapping(path = "/all")
    public List<Cathegory> getAllCathegories(){
        return cathegoryService.getAllCathegories();
    }

    @GetMapping(path = "/{id}")
    public Cathegory getCathegoryById(@PathVariable("id") Long id){
        return cathegoryService.getCathegoryById(id);
    }

    @GetMapping(path = "/byName/{name}")
    public Cathegory getCathegoryByName(@PathVariable("name") String name){
        return cathegoryService.getCathegoryByName(name);
    }

    @PostMapping(path = "/add")
    public void addNewCathegory(@RequestBody Cathegory cathegory){
        cathegoryService.addNewCathegory(cathegory);
    }

    @PutMapping(path = "/update")
    public void updateCathegory(@RequestBody Cathegory cathegory){
        cathegoryService.updateCathegory(cathegory.getId(), cathegory.getName());
    }

    @DeleteMapping(path = "/delete/{id}")
    public void deleteCathegory(@PathVariable("id") Long id){
        cathegoryService.deleteCathegory(id);
    }
}
