package com.Gym_PT.Gym_PT.controller;

import com.Gym_PT.Gym_PT.entity.DietLog;
import com.Gym_PT.Gym_PT.service.DietLogService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
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

    @GetMapping("/user/{userId}/date/{date}")
    public ResponseEntity<List<DietLog>> getByUserAndDate(@PathVariable Long userId, @PathVariable String date) {
        return ResponseEntity.ok(service.getByUserIdAndDate(userId, LocalDate.parse(date)));
    }
}
