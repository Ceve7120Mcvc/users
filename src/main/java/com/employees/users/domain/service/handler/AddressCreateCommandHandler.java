package com.employees.users.domain.service.handler;

import com.employees.users.domain.core.entity.Address;
import com.employees.users.domain.core.event.AddressCreateEvent;
import com.employees.users.domain.service.create.CreateAddressCommand;
import com.employees.users.domain.service.mapper.AddressDataMapper;
import com.employees.users.domain.service.ports.output.repository.AddressRepository;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.time.ZoneId;
import java.time.ZonedDateTime;

@Component
public class AddressCreateCommandHandler {
    private final AddressDataMapper addressDataMapper;
    private final AddressRepository addressRepository;

    public AddressCreateCommandHandler(AddressDataMapper addressDataMapper, AddressRepository addressRepository) {
        this.addressDataMapper = addressDataMapper;
        this.addressRepository = addressRepository;
    }

    @Transactional
    public AddressCreateEvent createAddress(CreateAddressCommand addressCommand){
        Address address = addressDataMapper.createAddressCommandToAddress(addressCommand);
        Address savedAddress = addressRepository.createAddress(address);
        return new AddressCreateEvent("saved successfully!", ZonedDateTime.now(ZoneId.of("UTC")));
    }


}
