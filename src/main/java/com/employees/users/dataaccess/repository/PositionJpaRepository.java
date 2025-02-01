package com.employees.users.dataaccess.repository;

import com.employees.users.dataaccess.entity.PositionEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PositionJpaRepository extends JpaRepository<PositionEntity, Long> {
}
