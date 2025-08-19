package com.Gym_PT.Gym_PT.repository;

import com.Gym_PT.Gym_PT.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {
}
