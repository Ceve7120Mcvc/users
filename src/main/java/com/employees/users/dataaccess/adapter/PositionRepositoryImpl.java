package com.employees.users.dataaccess.adapter;

import com.employees.users.dataaccess.entity.PositionEntity;
import com.employees.users.dataaccess.mapper.PositionDataAccessMapper;
import com.employees.users.dataaccess.repository.PositionJpaRepository;
import com.employees.users.domain.core.entity.Position;
import com.employees.users.domain.service.ports.output.repository.PositionRepository;
import org.springframework.stereotype.Component;

@Component
public class PositionRepositoryImpl implements PositionRepository {
    private final PositionDataAccessMapper positionDataAccessMapper;
    private final PositionJpaRepository positionJpaRepository;

    public PositionRepositoryImpl(PositionDataAccessMapper positionDataAccessMapper, PositionJpaRepository positionJpaRepository) {
        this.positionDataAccessMapper = positionDataAccessMapper;
        this.positionJpaRepository = positionJpaRepository;
    }


    @Override
    public Position createPosition(Position position) {
        PositionEntity positionEntity = positionDataAccessMapper.positionToPositionEntity(position);
        PositionEntity positionSaved = positionJpaRepository.save(positionEntity);
        return positionDataAccessMapper.positionEntityToUser(positionSaved);
    }
}
