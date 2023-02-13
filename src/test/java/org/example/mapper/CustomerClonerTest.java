package org.example.mapper;

import org.example.domain.City;
import org.example.domain.customer.Customer;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author Leonid Cheremshantsev
 */
class CustomerClonerTest {

    @Test
    void testClone() {
        var customer = Customer.builder()
                .name("Leonid")
                .city(new City("Samara"))
                .build();

        var clone = CustomerCloner.CLONER.clone(customer);

        assertEquals(customer.getName(), clone.getName());
        assertEquals(customer.getCity().getName(), clone.getCity().getName());
        assertNotSame(customer.getCity(), clone.getCity());
    }

}