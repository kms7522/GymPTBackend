package com.Gym_PT.Gym_PT.service;

import com.Gym_PT.Gym_PT.entity.DietLog;
import com.Gym_PT.Gym_PT.repository.DietLogRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class DietLogService {
    private final DietLogRepository repository;

    public DietLogService(DietLogRepository repository) {
        this.repository = repository;
    }

    public DietLog save(DietLog log) {
        return repository.save(log);
    }

    public List<DietLog> getByUserIdAndDate(Long userId, LocalDate date) {
        return repository.findByUserIdAndDate(userId, date);
    }
}
