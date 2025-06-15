package com.Gym_PT.Gym_PT.repository;

import com.Gym_PT.Gym_PT.entity.Calendar;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CalendarRepository extends JpaRepository<Calendar, Long> {
    List<Calendar> findByUserId(Long userId);
}
