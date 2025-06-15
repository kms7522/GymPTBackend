package com.Gym_PT.Gym_PT.controller;

import com.Gym_PT.Gym_PT.entity.DietItem;
import com.Gym_PT.Gym_PT.service.DietItemService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/diet-items")
public class DietItemController {
    private final DietItemService service;

    public DietItemController(DietItemService service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<DietItem> create(@RequestBody DietItem item) {
        return ResponseEntity.ok(service.save(item));
    }

    @GetMapping("/diet/{dietId}")
    public ResponseEntity<List<DietItem>> getByDiet(@PathVariable Long dietId) {
        return ResponseEntity.ok(service.getByDietId(dietId));
    }

    @GetMapping
    public ResponseEntity<List<DietItem>> getAll() {
        return ResponseEntity.ok(service.getAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<DietItem> getById(@PathVariable Long id) {
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
