package com.Gym_PT.Gym_PT.controller;

import com.Gym_PT.Gym_PT.entity.Calendar;
import com.Gym_PT.Gym_PT.service.CalendarService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/calendars")
public class CalendarController {

    private final CalendarService calendarService;

    public CalendarController(CalendarService calendarService) {
        this.calendarService = calendarService;
    }

    @PostMapping
    public ResponseEntity<Calendar> create(@RequestBody Calendar calendar) {
        return ResponseEntity.ok(calendarService.create(calendar));
    }

    @GetMapping("/user/{userId}")
    public ResponseEntity<List<Calendar>> getByUser(@PathVariable Long userId) {
        return ResponseEntity.ok(calendarService.getByUser(userId));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        calendarService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
