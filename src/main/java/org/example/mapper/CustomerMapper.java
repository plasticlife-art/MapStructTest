package org.example.mapper;

import org.example.domain.customer.Customer;
import org.example.domain.customer.CustomerDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

/**
 * @author Leonid Cheremshantsev
 */
@Mapper
public interface CustomerMapper {

    CustomerMapper MAPPER = Mappers.getMapper(CustomerMapper.class);
    String DATE_FORMAT = "yyyy.MM.dd hh:mm";

    @Mapping(target = "customerName", source = "name")
    @Mapping(target = "isActive", source = "active")
    @Mapping(target = "ordersCount", source = "orders")
    @Mapping(target = "registrationDate", source = "registration", dateFormat = DATE_FORMAT)
    @Mapping(target = "city", source = "city.name")
    CustomerDto toDto(Customer customer);

}
