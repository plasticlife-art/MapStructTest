package org.example.mapper;

import org.example.domain.product.Product;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * @author Leonid Cheremshantsev
 */
class ProductMapperTest {

    @Test
    void sameFieldNameAutoConversion() {

        var product = Product.builder()
                .name("Chips")
                .price(10.34)
                .count(100)
                .build();

        var productDto = ProductMapper.MAPPER.toDto(product);

        assertEquals(product.getName(), productDto.getName());
        assertEquals(String.valueOf(product.getPrice()), productDto.getPrice());
        assertEquals(product.getCount(), productDto.getCount());
    }

    @Test
    void defaultValue() {
        var product = Product.builder()
                .build();

        var productDto = ProductMapper.MAPPER.toDto(product);

        assertEquals(1, productDto.getCount());
    }

    @Test
    void numberFormat() {
        var product = Product.builder()
                .price(10.1231243)
                .build();

        var productDto = ProductMapper.MAPPER.toDto(product);

        assertEquals("10.12", productDto.getPrice());
    }

}