package com.employees.users.domain.service.ports.output.repository;

import com.employees.users.domain.core.entity.Address;
import com.employees.users.domain.core.entity.Position;

public interface AddressRepository {
    Address createAddress(Address address);
}
