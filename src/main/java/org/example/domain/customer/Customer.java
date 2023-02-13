package org.example.domain.customer;

import lombok.Builder;
import lombok.Data;
import org.example.domain.City;

import java.util.Date;

/**
 * @author Leonid Cheremshantsev
 */
@Data
@Builder
public class Customer {

    private String name;
    private Boolean active;
    private Integer orders;
    private Date registration;
    private City city;
}
