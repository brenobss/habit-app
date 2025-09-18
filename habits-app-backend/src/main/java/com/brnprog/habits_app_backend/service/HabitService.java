package com.brnprog.habits_app_backend.service;

import com.brnprog.habits_app_backend.model.Habit;
import com.brnprog.habits_app_backend.repository.IHabitRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class HabitService {

    @Autowired
    private IHabitRepository habitRepository;

    public Habit createHabit(Habit habit){
        return habitRepository.save(habit);
    }

    public List<Habit> findHabitsByUserId(Long userId){
        return habitRepository.findByUser_Id(userId);
    }

    public Habit getHabitById(Long id){
        return habitRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Hábito não encontrado com o id: " + id));
    }

    public Habit updateHabit(Long id, Habit habitDetails){
        Habit existingHabit = getHabitById(id);
        existingHabit.setName(habitDetails.getName());
        existingHabit.setDescription(habitDetails.getDescription());
        existingHabit.setFrequency(habitDetails.getFrequency());
        existingHabit.setDaysOfWeek(habitDetails.getDaysOfWeek());
        existingHabit.setGoal(habitDetails.getGoal());
        existingHabit.setType(habitDetails.getType());
        return habitRepository.save(existingHabit);
    }

    public void deleteHabit(Long id){
        if(!habitRepository.existsById(id)){
            throw new RuntimeException("Hábito não encontrado com o id: " + id);
        }
        habitRepository.deleteById(id);
    }
}
