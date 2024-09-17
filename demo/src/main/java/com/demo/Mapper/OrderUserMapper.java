package com.demo.Mapper;

import com.demo.dto.OrderUserDto;

public class OrderUserMapper {
    public static OrderUserDto toDto(Object[] result) {
        OrderUserDto dto = new OrderUserDto();

        dto.setId(((Number) result[0]).intValue());
        dto.setName((String) result[1]);
        dto.setVille((String) result[2]);
        dto.setRepas_livres(((Number) result[3]).intValue());
        dto.setRepas_annules(((Number) result[4]).intValue());

        return dto;
    }
}
