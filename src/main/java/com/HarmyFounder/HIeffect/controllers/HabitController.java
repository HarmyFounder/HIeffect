package com.HarmyFounder.HIeffect.controllers;

import com.HarmyFounder.HIeffect.models.Habit;
import com.HarmyFounder.HIeffect.services.HabitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/habit")
public class HabitController {

    @Autowired
    private HabitService habitService;

    @GetMapping("/all")
    public List<Habit> getAll() {
        return habitService.getAll();
    }

    @GetMapping("/{id}")
    public Habit getCertain(@PathVariable("id") Habit habit) {
        return habit;
    }

    @PostMapping("/create")
    public Habit create(@RequestBody Habit habit) {
        return habitService.create(habit);
    }

    @PostMapping("/{id}/completed")
    public Habit markAsDone(@PathVariable("id") Habit habit) {
        return habitService.changeStatus(habit);
    }

    @PutMapping("/{id}/edit")
    public Habit update(@PathVariable("id") Habit habitToBeUpdated, @RequestBody Habit updatedHabit) {
        return habitService.update(habitToBeUpdated, updatedHabit);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable("id") Habit habit) {
        habitService.delete(habit);
    }

}
