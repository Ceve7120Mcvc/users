package com.employees.users.dataaccess.repository;

import com.employees.users.dataaccess.entity.AddressEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AddressJpaRepository extends JpaRepository<AddressEntity, Long> {
}
