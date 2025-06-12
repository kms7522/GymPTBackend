package com.Gym_PT.Gym_PT.controller;

import com.Gym_PT.Gym_PT.entity.SetWorkoutLog;
import com.Gym_PT.Gym_PT.service.SetWorkoutLogService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/set-workouts")
public class SetWorkoutLogController {
    private final SetWorkoutLogService service;

    public SetWorkoutLogController(SetWorkoutLogService service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<SetWorkoutLog> create(@RequestBody SetWorkoutLog log) {
        return ResponseEntity.ok(service.save(log));
    }

    @GetMapping("/each/{eachId}")
    public ResponseEntity<List<SetWorkoutLog>> getByEach(@PathVariable Long eachId) {
        return ResponseEntity.ok(service.getByEachId(eachId));
    }
}
