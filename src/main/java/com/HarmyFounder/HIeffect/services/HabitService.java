package com.HarmyFounder.HIeffect.services;

import com.HarmyFounder.HIeffect.models.Habit;
import com.HarmyFounder.HIeffect.repositories.HabitRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HabitService {

    @Autowired
    private HabitRepository habitRepository;

    public List<Habit> getAll(){
        return habitRepository.findAll();
    }

    public Habit create(Habit habit){
        return habitRepository.save(habit);
    }

    public Habit update(Habit habitToBeUpdated, Habit updatedHabit){
        BeanUtils.copyProperties(updatedHabit, habitToBeUpdated,"id");
        return habitRepository.save(habitToBeUpdated);
    }

    public void delete(Habit habit){
        habitRepository.delete(habit);
    }

    public Habit changeStatus(Habit habit){
        habit.setDone(true);
        return habitRepository.save(habit);
    }

}
