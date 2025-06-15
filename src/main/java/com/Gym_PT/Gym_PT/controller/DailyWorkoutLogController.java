package com.Gym_PT.Gym_PT.controller;

import com.Gym_PT.Gym_PT.entity.DailyWorkoutLog;
import com.Gym_PT.Gym_PT.service.DailyWorkoutLogService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/daily-workouts")
public class DailyWorkoutLogController {
    private final DailyWorkoutLogService service;

    public DailyWorkoutLogController(DailyWorkoutLogService service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<DailyWorkoutLog> create(@RequestBody DailyWorkoutLog log) {
        return ResponseEntity.ok(service.save(log));
    }

    @GetMapping("/user/{userId}")
    public ResponseEntity<List<DailyWorkoutLog>> getByUser(@PathVariable Long userId) {
        return ResponseEntity.ok(service.getByUserId(userId));
    }

    @GetMapping
    public ResponseEntity<List<DailyWorkoutLog>> getAll() {
        return ResponseEntity.ok(service.getAll());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }

}
