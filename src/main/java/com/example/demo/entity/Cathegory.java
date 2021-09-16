package com.example.demo.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.*;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Cathegory {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String name;

    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<Task> tasks;

    public Cathegory(String name) {
        this.name = name;
    }
}
