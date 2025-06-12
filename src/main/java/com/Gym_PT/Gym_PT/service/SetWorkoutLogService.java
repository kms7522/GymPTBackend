package com.Gym_PT.Gym_PT.service;

import com.Gym_PT.Gym_PT.entity.SetWorkoutLog;
import com.Gym_PT.Gym_PT.repository.SetWorkoutLogRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SetWorkoutLogService {
    private final SetWorkoutLogRepository repository;

    public SetWorkoutLogService(SetWorkoutLogRepository repository) {
        this.repository = repository;
    }

    public SetWorkoutLog save(SetWorkoutLog log) {
        return repository.save(log);
    }

    public List<SetWorkoutLog> getByEachId(Long eachId) {
        return repository.findByEachWorkoutLogId(eachId);
    }
}
