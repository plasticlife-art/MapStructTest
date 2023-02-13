package org.example.domain.customer;

import lombok.Builder;
import lombok.Data;

/**
 * @author Leonid Cheremshantsev
 */
@Data
@Builder
public class CustomerDto {

    private String customerName;
    private boolean isActive;
    private int ordersCount;
    private String registrationDate;
    private String city;

}
