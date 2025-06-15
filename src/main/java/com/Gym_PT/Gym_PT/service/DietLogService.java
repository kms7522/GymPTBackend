package com.Gym_PT.Gym_PT.service;

import com.Gym_PT.Gym_PT.entity.DailyWorkoutLog;
import com.Gym_PT.Gym_PT.entity.DietLog;
import com.Gym_PT.Gym_PT.repository.DietLogRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DietLogService {
    private final DietLogRepository repository;

    public DietLogService(DietLogRepository repository) {
        this.repository = repository;
    }

    public DietLog save(DietLog log) {
        return repository.save(log);
    }

    public List<DietLog> getByUserId(Long userId) {
        return repository.findByUserId(userId);
    }

    public List<DietLog> getAll() {
        return repository.findAll();
    }

    public Optional<DietLog> getById(Long id) {
        return repository.findById(id);
    }

    public void delete(Long id) {
        repository.deleteById(id);
    }
}
