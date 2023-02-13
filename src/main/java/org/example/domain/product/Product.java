package org.example.domain.product;

import lombok.Builder;
import lombok.Data;

/**
 * @author Leonid Cheremshantsev
 */
@Data
@Builder
public class Product {

    private String name;
    private Double price;
    private Integer count;
    private String providerName;
    private String andOtherFields;
}
