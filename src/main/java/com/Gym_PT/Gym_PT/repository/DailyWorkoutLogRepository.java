package com.Gym_PT.Gym_PT.repository;

import com.Gym_PT.Gym_PT.entity.DailyWorkoutLog;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface DailyWorkoutLogRepository extends JpaRepository<DailyWorkoutLog, Long> {
    List<DailyWorkoutLog> findByUserId(Long userId);
}