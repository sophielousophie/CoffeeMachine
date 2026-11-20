package org.formation.mapper;

import org.formation.dto.CoffeeCreateDto;
import org.formation.dto.CoffeeDto;
import org.formation.dto.CoffeeUpdateDto;
import org.formation.entity.Coffee;
import org.mapstruct.*;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.ERROR)
public interface CoffeeMapper {
    CoffeeDto toDto(Coffee coffee);
    @Mapping(target = "id", ignore = true)
    Coffee toEntity(CoffeeCreateDto dto);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    @Mapping(target = "id", ignore = true)
    void updateEntity(@MappingTarget Coffee entity, CoffeeUpdateDto dto);
}
