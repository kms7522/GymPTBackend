package com.Gym_PT.Gym_PT.service;

import com.Gym_PT.Gym_PT.entity.DietItem;
import com.Gym_PT.Gym_PT.repository.DietItemRepository;
import org.springframework.stereotype.Service;

import java.util.List;

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
}
