package com.example.demo.service;

import com.example.demo.entity.Cathegory;
import com.example.demo.repository.CathegoryRepository;
import javassist.NotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CathegoryService {
    private final CathegoryRepository cathegoryRepository;

    public List<Cathegory> getAllCathegories(){
        return cathegoryRepository.findAll();
    }

    public Cathegory getCathegoryById(Long id){
        Cathegory cathegory = cathegoryRepository.findById(id)
                .orElseThrow(() ->  new IllegalStateException(
                        String.format("Cathegory with id %s not found", id)));
        return cathegory;
    }

    public Cathegory getCathegoryByName(String name){
        Cathegory cathegory = cathegoryRepository.findCathegoryByName(name)
                .orElseThrow(() ->  new IllegalStateException(
                        String.format("Cathegory with name %s not found", name)));
        return cathegory;
    }

    public void addNewCathegory(Cathegory cathegory){
        cathegoryRepository.save(cathegory);
    }

    public void updateCathegory(Long id, String newName){
        Cathegory cathegory = cathegoryRepository.findById(id)
                .orElseThrow(() ->  new IllegalStateException(
                        String.format("Cathegory with id %s not found", id)));
        cathegory.setName(newName);
        cathegoryRepository.save(cathegory);
    }

    public void deleteCathegory(Long id){
        Cathegory cathegory = cathegoryRepository.findById(id)
                .orElseThrow(() ->  new IllegalStateException(
                        String.format("Cathegory with id %s not found", id)));
        cathegoryRepository.delete(cathegory);
    }
}
