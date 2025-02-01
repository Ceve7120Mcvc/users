package com.employees.users.dataaccess.adapter;

import com.employees.users.dataaccess.entity.EmployeesEntity;
import com.employees.users.dataaccess.entity.PositionEntity;
import com.employees.users.dataaccess.mapper.EmployeesAccessMapper;
import com.employees.users.dataaccess.mapper.PositionAccessMapper;
import com.employees.users.dataaccess.repository.EmployeesJpaRepository;
import com.employees.users.dataaccess.repository.PositionJpaRepository;
import com.employees.users.domain.core.entity.Employees;
import com.employees.users.domain.core.entity.Position;
import com.employees.users.domain.service.ports.output.repository.EmployeesRepository;
import com.employees.users.domain.service.ports.output.repository.PositionRepository;
import org.springframework.stereotype.Component;

@Component
public class PositionRepositoryImpl implements PositionRepository {
    private final PositionAccessMapper positionAccessMapper;
    private final PositionJpaRepository positionJpaRepository;

    public PositionRepositoryImpl(PositionAccessMapper positionAccessMapper, PositionJpaRepository positionJpaRepository) {
        this.positionAccessMapper = positionAccessMapper;
        this.positionJpaRepository = positionJpaRepository;
    }


    @Override
    public Position createPosition(Position position) {
        PositionEntity positionEntity = positionAccessMapper.positionToPositionEntity(position);
        PositionEntity positionSaved = positionJpaRepository.save(positionEntity);
        return positionAccessMapper.positionEntityToUser(positionSaved);
    }
}
