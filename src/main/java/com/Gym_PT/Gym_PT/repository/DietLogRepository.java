package com.Gym_PT.Gym_PT.repository;

import com.Gym_PT.Gym_PT.entity.DietLog;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.util.List;

public interface DietLogRepository extends JpaRepository<DietLog, Long> {
    List<DietLog> findByUserId(Long userId);
}