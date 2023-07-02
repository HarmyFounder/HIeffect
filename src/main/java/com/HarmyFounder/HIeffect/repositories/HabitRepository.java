package com.HarmyFounder.HIeffect.repositories;

import com.HarmyFounder.HIeffect.models.Habit;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HabitRepository extends JpaRepository<Habit, Long> {



}
