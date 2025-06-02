package com.gerenciartimes.repository;

import com.gerenciartimes.entity.Time;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TimeRepository extends JpaRepository<Time, Long> {
}
