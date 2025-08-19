package com.brnprog.habits_app_backend.repository;

import com.brnprog.habits_app_backend.model.Habit;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IHabitRepository extends JpaRepository<Habit, Long> {
}
