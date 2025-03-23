package edu.ijse.therapycenter.util;

import org.modelmapper.ModelMapper;

public class ConverterUtil {
    private static final ModelMapper modelMapper = new ModelMapper();

    public static <D, E> E toEntity(D dto, Class<E> entityClass) {
        return modelMapper.map(dto, entityClass);
    }

    public static <E, D> D toDTO(E entity, Class<D> dtoClass) {
        return modelMapper.map(entity, dtoClass);
    }
}
