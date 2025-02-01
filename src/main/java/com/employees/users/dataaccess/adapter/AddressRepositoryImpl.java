package com.employees.users.dataaccess.adapter;

import com.employees.users.dataaccess.entity.AddressEntity;
import com.employees.users.dataaccess.mapper.AddressAccessMapper;
import com.employees.users.dataaccess.repository.AddressJpaRepository;
import com.employees.users.domain.core.entity.Address;
import com.employees.users.domain.service.ports.output.repository.AddressRepository;
import org.springframework.stereotype.Component;

@Component
public class AddressRepositoryImpl implements AddressRepository {
    private final AddressAccessMapper addressAccessMapper;
    private final AddressJpaRepository addressJpaRepository;

    public AddressRepositoryImpl(AddressAccessMapper addressAccessMapper, AddressJpaRepository addressJpaRepository) {
        this.addressAccessMapper = addressAccessMapper;
        this.addressJpaRepository = addressJpaRepository;
    }

    @Override
    public Address createAddress(Address address) {
        AddressEntity addressEntity = addressAccessMapper.addressToAddressEntity(address);
        AddressEntity addressSaved = addressJpaRepository.save(addressEntity);
        return addressAccessMapper.addressEntityToAddress(addressSaved);
    }
}
