package com.Gym_PT.Gym_PT.service;

import com.Gym_PT.Gym_PT.entity.DailyWorkoutLog;
import com.Gym_PT.Gym_PT.repository.DailyWorkoutLogRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DailyWorkoutLogService {
    private final DailyWorkoutLogRepository repository;

    public DailyWorkoutLogService(DailyWorkoutLogRepository repository) {
        this.repository = repository;
    }

    public DailyWorkoutLog save(DailyWorkoutLog log) {
        return repository.save(log);
    }

    public List<DailyWorkoutLog> getByUserId(Long userId) {
        return repository.findByUserId(userId);
    }

    public List<DailyWorkoutLog> getAll() {
        return repository.findAll();
    }

    public void delete(Long id) {
        repository.deleteById(id);
    }

}
