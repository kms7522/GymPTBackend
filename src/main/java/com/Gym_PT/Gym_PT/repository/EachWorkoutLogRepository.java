package com.Gym_PT.Gym_PT.repository;

import com.Gym_PT.Gym_PT.entity.EachWorkoutLog;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface EachWorkoutLogRepository extends JpaRepository<EachWorkoutLog, Long> {
    List<EachWorkoutLog> findByDailyWorkoutLogId(Long dailyId);
}