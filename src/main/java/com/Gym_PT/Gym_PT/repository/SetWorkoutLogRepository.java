package com.Gym_PT.Gym_PT.repository;

import com.Gym_PT.Gym_PT.entity.SetWorkoutLog;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface SetWorkoutLogRepository extends JpaRepository<SetWorkoutLog, Long> {
    List<SetWorkoutLog> findByEachWorkoutLogId(Long eachId);
}