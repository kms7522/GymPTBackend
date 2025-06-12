package com.Gym_PT.Gym_PT.service;

import com.Gym_PT.Gym_PT.entity.CalendarEntry;
import com.Gym_PT.Gym_PT.entity.CalendarId;
import com.Gym_PT.Gym_PT.repository.CalendarRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
public class CalendarService {
    private final CalendarRepository calendarRepository;

    public CalendarService(CalendarRepository calendarRepository) {
        this.calendarRepository = calendarRepository;
    }

    public CalendarEntry save(CalendarEntry entry) {
        return calendarRepository.save(entry);
    }

    public Optional<CalendarEntry> getByUserAndDate(Long userId, LocalDate date) {
        return calendarRepository.findByUserIdAndDate(userId, date);
    }

    public List<CalendarEntry> getAllByUser(Long userId) {
        return calendarRepository.findByUserId(userId);
    }

    public void delete(CalendarId id) {
        calendarRepository.deleteById(id);
    }
}