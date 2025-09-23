package com.brnprog.habits_app_backend.controller;

import com.brnprog.habits_app_backend.model.Habit;
import com.brnprog.habits_app_backend.service.HabitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/habits")
public class HabitController {
    @Autowired private HabitService habitService;

    @GetMapping("/{id}")
    public ResponseEntity getHabitById(@PathVariable Long id){
        Habit habit = habitService.getHabitById(id);
        return ResponseEntity.ok(habit);
    }

    @PostMapping
    public ResponseEntity createHabit(@RequestBody Habit habit){
        Habit newHabity = habitService.createHabit(habit);
        return ResponseEntity.ok(newHabity);
    }

    @PutMapping("/{id}")
    public ResponseEntity updateHabit(@PathVariable Long id, @RequestBody Habit habitDetails){
        Habit updatedHabit = habitService.updateHabit(id, habitDetails);
        return ResponseEntity.ok(updatedHabit);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity deleteHabit(@PathVariable Long id){
        habitService.deleteHabit(id);
        return ResponseEntity.noContent().build();
    }
}
