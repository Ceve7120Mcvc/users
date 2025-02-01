package com.employees.users.dataaccess.adapter;

import com.employees.users.dataaccess.entity.AddressEntity;
import com.employees.users.dataaccess.mapper.AddressDataAccessMapper;
import com.employees.users.dataaccess.repository.AddressJpaRepository;
import com.employees.users.domain.core.entity.Address;
import com.employees.users.domain.service.ports.output.repository.AddressRepository;
import org.springframework.stereotype.Component;

@Component
public class AddressRepositoryImpl implements AddressRepository {
    private final AddressDataAccessMapper addressDataAccessMapper;
    private final AddressJpaRepository addressJpaRepository;

    public AddressRepositoryImpl(AddressDataAccessMapper addressDataAccessMapper, AddressJpaRepository addressJpaRepository) {
        this.addressDataAccessMapper = addressDataAccessMapper;
        this.addressJpaRepository = addressJpaRepository;
    }

    @Override
    public Address createAddress(Address address) {
        AddressEntity addressEntity = addressDataAccessMapper.addressToAddressEntity(address);
        AddressEntity addressSaved = addressJpaRepository.save(addressEntity);
        return addressDataAccessMapper.addressEntityToAddress(addressSaved);
    }
}
