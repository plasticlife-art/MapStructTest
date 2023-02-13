package org.example.domain.product;

import lombok.Data;

/**
 * @author Leonid Cheremshantsev
 */
@Data
public class ProductDto {

    private String name;
    private String price;
    private int count;

}
