package com.Gym_PT.Gym_PT.repository;

import com.Gym_PT.Gym_PT.entity.CalendarEntry;
import com.Gym_PT.Gym_PT.entity.CalendarId;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

public interface CalendarRepository extends JpaRepository<CalendarEntry, CalendarId> {
    List<CalendarEntry> findByUserId(Long userId);
    Optional<CalendarEntry> findByUserIdAndDate(Long userId, LocalDate date);
}