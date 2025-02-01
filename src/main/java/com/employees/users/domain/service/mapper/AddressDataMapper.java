package com.employees.users.domain.service.mapper;

import com.employees.users.domain.core.entity.Address;
import com.employees.users.domain.core.entity.Position;
import com.employees.users.domain.service.create.CreateAddressCommand;
import com.employees.users.domain.service.create.CreateAddressResponse;
import com.employees.users.domain.service.create.CreatePositionCommand;
import com.employees.users.domain.service.create.CreatePositionResponse;
import org.springframework.stereotype.Component;

@Component
public class AddressDataMapper {
    public Address createAddressCommandToAddress(CreateAddressCommand addressCommand){
        return new Address(
                null,
                addressCommand.getStreet(),
                addressCommand.getExterior(),
                addressCommand.getInterior(),
                addressCommand.getColony(),
                addressCommand.getMunicipality(),
                addressCommand.getState(),
                addressCommand.getCountry()
        );
    }

    public CreateAddressResponse addressToCreateAddressResponse(String message){
        return new CreateAddressResponse(message);
    }
}
