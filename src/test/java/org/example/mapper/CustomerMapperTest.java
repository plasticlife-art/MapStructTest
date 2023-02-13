package org.example.mapper;

import org.example.domain.City;
import org.example.domain.customer.Customer;
import org.junit.jupiter.api.Test;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import static java.util.Calendar.FEBRUARY;
import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * @author Leonid Cheremshantsev
 */
class CustomerMapperTest {

    @Test
    void customFieldMapping() {
        var customer = Customer.builder()
                .name("Leonid Cheremshantsev")
                .active(true)
                .orders(10)
                .build();

        var customerDto = CustomerMapper.MAPPER.toDto(customer);

        assertEquals(customer.getName(), customerDto.getCustomerName());
        assertEquals(customer.getActive(), customerDto.isActive());
        assertEquals(customer.getOrders(), customerDto.getOrdersCount());
    }


    @Test
    void dateConversion() {
        var calendar = Calendar.getInstance();
        calendar.set(2023, FEBRUARY, 13, 10, 30);
        var date = new Date(calendar.getTimeInMillis());

        var customer = Customer.builder()
                .registration(date)
                .build();

        var customerDto = CustomerMapper.MAPPER.toDto(customer);

        assertEquals(new SimpleDateFormat(CustomerMapper.DATE_FORMAT).format(customer.getRegistration()), customerDto.getRegistrationDate());
    }

    @Test
    void objectFieldConversion() {
        var customer = Customer.builder()
                .city(new City("Samara"))
                .build();

        var customerDto = CustomerMapper.MAPPER.toDto(customer);

        assertEquals(customer.getCity().getName(), customerDto.getCity());
    }
}