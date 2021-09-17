package com.example.demo.entity;

import lombok.*;

import javax.persistence.*;

@Entity
@Data
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Task {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @ManyToOne(fetch = FetchType.EAGER, optional = false)
    private Priority priority;

    @ManyToOne(fetch = FetchType.EAGER, optional = false)
    private Cathegory cathegory;

    @ManyToOne(fetch = FetchType.EAGER, optional = false)
    private AppUser appUser;

    private String text;

    public Task(Priority priority, Cathegory cathegory, AppUser appUser, String text) {
        this.priority = priority;
        this.cathegory = cathegory;
        this.appUser = appUser;
        this.text = text;
    }

    public Task(String text) {
        this.text = text;
    }
}
