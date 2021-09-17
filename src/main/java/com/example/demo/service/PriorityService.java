package com.example.demo.service;

import com.example.demo.entity.Cathegory;
import com.example.demo.entity.Priority;
import com.example.demo.repository.CathegoryRepository;
import com.example.demo.repository.PriorityRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PriorityService{
        private final PriorityRepository priorityRepository;

        public List<Priority> getAllPriorities(){
            return priorityRepository.findAll();
        }

        public Priority getPriorityById(Long id){
            Priority priority = priorityRepository.findById(id)
                    .orElseThrow(() ->  new IllegalStateException(
                            String.format("Priority with id %s not found", id)));
            return priority;
        }

        public Priority getPriorityByName(String name){
            Priority priority = priorityRepository.findPriorityByName(name)
                    .orElseThrow(() ->  new IllegalStateException(
                            String.format("Priority with name %s not found", name)));
            return priority;
        }

        public void addNewPriority(Priority priority){
            priorityRepository.save(priority);
        }

        public void updatePriority(Long id, String newName){
            Priority priority = priorityRepository.findById(id)
                    .orElseThrow(() ->  new IllegalStateException(
                            String.format("Priority with id %s not found", id)));
            priority.setName(newName);
        }

        public void deletePriority(Long id){
            Priority priority = priorityRepository.findById(id)
                    .orElseThrow(() ->  new IllegalStateException(
                            String.format("Priority with id %s not found", id)));
            priorityRepository.delete(priority);
        }
}