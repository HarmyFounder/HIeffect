package com.HarmyFounder.HIeffect.repositories;

import com.HarmyFounder.HIeffect.models.Task;
import com.HarmyFounder.HIeffect.models.TaskStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TaskRepository extends JpaRepository<Task, Long> {

    List<Task> findByTaskStatus(TaskStatus taskStatus);

}
