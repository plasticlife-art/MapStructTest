package org.example.mapper;

import org.example.domain.product.Product;
import org.example.domain.product.ProductDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

/**
 * @author Leonid Cheremshantsev
 */
@Mapper
public interface ProductMapper {

    ProductMapper MAPPER = Mappers.getMapper(ProductMapper.class);


    @Mapping(target = "price", source = "price", defaultValue = "0", numberFormat = ".00")
    @Mapping(target = "count", source = "count", defaultValue = "1")
    ProductDto toDto(Product product);
}
