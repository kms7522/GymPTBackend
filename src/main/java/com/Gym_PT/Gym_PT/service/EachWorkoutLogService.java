package com.Gym_PT.Gym_PT.service;

import com.Gym_PT.Gym_PT.entity.EachWorkoutLog;
import com.Gym_PT.Gym_PT.repository.EachWorkoutLogRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EachWorkoutLogService {
    private final EachWorkoutLogRepository repository;

    public EachWorkoutLogService(EachWorkoutLogRepository repository) {
        this.repository = repository;
    }

    public EachWorkoutLog save(EachWorkoutLog log) {
        return repository.save(log);
    }

    public List<EachWorkoutLog> getByDailyId(Long dailyId) {
        return repository.findByDailyWorkoutLogId(dailyId);
    }

    public List<EachWorkoutLog> getAll() {
        return repository.findAll();
    }

    public void delete(Long id) {
        repository.deleteById(id);
    }

}
