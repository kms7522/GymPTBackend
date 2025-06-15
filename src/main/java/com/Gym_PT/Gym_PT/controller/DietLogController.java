package com.Gym_PT.Gym_PT.controller;

import com.Gym_PT.Gym_PT.entity.DailyWorkoutLog;
import com.Gym_PT.Gym_PT.entity.DietLog;
import com.Gym_PT.Gym_PT.service.DietLogService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/diet-logs")
public class DietLogController {
    private final DietLogService service;

    public DietLogController(DietLogService service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<DietLog> create(@RequestBody DietLog log) {
        return ResponseEntity.ok(service.save(log));
    }

    @GetMapping("/user/{userId}")
    public ResponseEntity<List<DietLog>> getByUser(@PathVariable Long userId) {
        return ResponseEntity.ok(service.getByUserId(userId));
    }

    @GetMapping
    public ResponseEntity<List<DietLog>> getAll() {
        return ResponseEntity.ok(service.getAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<DietLog> getById(@PathVariable Long id) {
        return service.getById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }
}
