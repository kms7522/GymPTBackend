package com.Gym_PT.Gym_PT.service;

import com.Gym_PT.Gym_PT.entity.Calendar;
import com.Gym_PT.Gym_PT.repository.CalendarRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CalendarService {

    private final CalendarRepository calendarRepository;

    public CalendarService(CalendarRepository calendarRepository) {
        this.calendarRepository = calendarRepository;
    }

    public Calendar create(Calendar calendar) {
        return calendarRepository.save(calendar);
    }

    public List<Calendar> getByUser(Long userId) {
        return calendarRepository.findByUserId(userId);
    }

    public void delete(Long id) {
        calendarRepository.deleteById(id);
    }
}
