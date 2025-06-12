package com.Gym_PT.Gym_PT.controller;

import com.Gym_PT.Gym_PT.entity.EachWorkoutLog;
import com.Gym_PT.Gym_PT.service.EachWorkoutLogService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/each-workouts")
public class EachWorkoutLogController {
    private final EachWorkoutLogService service;

    public EachWorkoutLogController(EachWorkoutLogService service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<EachWorkoutLog> create(@RequestBody EachWorkoutLog log) {
        return ResponseEntity.ok(service.save(log));
    }

    @GetMapping("/daily/{dailyId}")
    public ResponseEntity<List<EachWorkoutLog>> getByDaily(@PathVariable Long dailyId) {
        return ResponseEntity.ok(service.getByDailyId(dailyId));
    }
}
