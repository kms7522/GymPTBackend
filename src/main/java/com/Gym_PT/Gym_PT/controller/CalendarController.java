package com.Gym_PT.Gym_PT.controller;

import com.Gym_PT.Gym_PT.entity.CalendarEntry;
import com.Gym_PT.Gym_PT.entity.CalendarId;
import com.Gym_PT.Gym_PT.service.CalendarService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/calendar")
public class CalendarController {
    private final CalendarService calendarService;

    public CalendarController(CalendarService calendarService) {
        this.calendarService = calendarService;
    }

    @PostMapping
    public ResponseEntity<CalendarEntry> createOrUpdate(@RequestBody CalendarEntry entry) {
        return ResponseEntity.ok(calendarService.save(entry));
    }

    @GetMapping("/{userId}/{date}")
    public ResponseEntity<Optional<CalendarEntry>> getEntry(@PathVariable Long userId, @PathVariable String date) {
        return ResponseEntity.ok(calendarService.getByUserAndDate(userId, LocalDate.parse(date)));
    }

    @GetMapping("/{userId}")
    public ResponseEntity<List<CalendarEntry>> getAll(@PathVariable Long userId) {
        return ResponseEntity.ok(calendarService.getAllByUser(userId));
    }

    @DeleteMapping("/{userId}/{date}")
    public ResponseEntity<Void> deleteEntry(@PathVariable Long userId, @PathVariable String date) {
        calendarService.delete(new CalendarId(userId, LocalDate.parse(date)));
        return ResponseEntity.noContent().build();
    }
}
