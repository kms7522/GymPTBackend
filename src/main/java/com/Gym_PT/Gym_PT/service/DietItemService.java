package com.Gym_PT.Gym_PT.service;

import com.Gym_PT.Gym_PT.entity.DietItem;
import com.Gym_PT.Gym_PT.repository.DietItemRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DietItemService {
    private final DietItemRepository repository;

    public DietItemService(DietItemRepository repository) {
        this.repository = repository;
    }

    public DietItem save(DietItem item) {
        return repository.save(item);
    }

    public List<DietItem> getByDietId(Long dietId) {
        return repository.findByDietLogId(dietId);
    }

    public List<DietItem> getAll() {
        return repository.findAll();
    }

    public Optional<DietItem> getById(Long id) {
        return repository.findById(id);
    }

    public void delete(Long id) {
        repository.deleteById(id);
    }
}
