package com.employees.users.dataaccess.mapper;

import com.employees.users.common.domain.valueonject.AddressId;
import com.employees.users.common.domain.valueonject.EmployeesId;
import com.employees.users.dataaccess.entity.AddressEntity;
import com.employees.users.dataaccess.entity.EmployeesEntity;
import com.employees.users.dataaccess.entity.PositionEntity;
import com.employees.users.domain.core.entity.Address;
import com.employees.users.domain.core.entity.Employees;
import com.employees.users.domain.core.entity.Position;
import org.springframework.stereotype.Component;

@Component
public class AddressAccessMapper {
    public AddressEntity addressToAddressEntity(Address address){
        return AddressEntity.builder()
                .idAddress(address.getId().getValue())
                .street(address.getStreet())
                .exterior(address.getExterior())
                .interior(address.getInterior())
                .colony(address.getColony())
                .municipality(address.getMunicipality())
                .state(address.getState())
                .country(address.getCountry())
                .build();
    }

    public Address addressEntityToAddress(AddressEntity addressEntity){
        AddressId id = addressEntity.getIdAddress() != null ? new AddressId(addressEntity.getIdAddress()) : null;
        return new Address(
                id,
                addressEntity.getStreet(),
                addressEntity.getExterior(),
                addressEntity.getInterior(),
                addressEntity.getColony(),
                addressEntity.getMunicipality(),
                addressEntity.getState(),
                addressEntity.getCountry()
        );
    }

}
