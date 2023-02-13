package org.example.mapper;

import org.example.domain.customer.Customer;
import org.mapstruct.Mapper;
import org.mapstruct.control.DeepClone;
import org.mapstruct.factory.Mappers;

/**
 * @author Leonid Cheremshantsev
 */

@Mapper(mappingControl = DeepClone.class)
public interface CustomerCloner {

    CustomerCloner CLONER = Mappers.getMapper(CustomerCloner.class);

    Customer clone(Customer customer);
}
