package com.Gym_PT.Gym_PT.repository;

import com.Gym_PT.Gym_PT.entity.DietItem;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface DietItemRepository extends JpaRepository<DietItem, Long> {
    List<DietItem> findByDietLogId(Long dietId);
}