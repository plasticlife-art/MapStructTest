MapStruct is an annotation-based code generator that is useful in multilayer applications to map between different object models (e.g. entities and DTOs) (e.g. entities and DTOs)

## Simplest example
If source and target have fields with the same names and specific formatting is not required mapper can be created as simple as this:
```java
@Mapper  
public interface ProductMapper {  
  
    ProductMapper MAPPER = Mappers.getMapper(ProductMapper.class);  
    
    ProductDto toDto(Product product);  
}
```
or in case of using Spring context:
```java
@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface ProductMapper {  
    ProductDto toDto(Product product);  
}
```

## Custom mapper
If classes have fields with different names or formatting required it can be done like this:
```java
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
```

## Deep clone
MapStruct also allows the generation of deep cloner
```java
@Mapper(mappingControl = DeepClone.class)  
public interface CustomerCloner {  
  
    CustomerCloner CLONER = Mappers.getMapper(CustomerCloner.class);  
  
    Customer clone(Customer customer);  
}
```