package com.brnprog.habits_app_backend.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor

@Entity
public class Habit {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private String description;

    private String frequency;

    @ElementCollection
    private List<String> daysOfWeek;

    private String goal;

    private String type;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user;
}
