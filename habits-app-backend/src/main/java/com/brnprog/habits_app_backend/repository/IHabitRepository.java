package com.brnprog.habits_app_backend.repository;

import com.brnprog.habits_app_backend.model.Habit;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IHabitRepository extends JpaRepository<Habit, Long> {
    List<Habit> findByUser_Id(Long userId);
}
