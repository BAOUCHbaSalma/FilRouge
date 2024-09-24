package com.demo.dto;

import lombok.Getter;
import lombok.Setter;
import org.springframework.web.service.annotation.GetExchange;

@Setter
@Getter
public class OrderUserDto {
    private Integer id;
    private String name;
    private String ville;
    private Integer repas_livres;
    private Integer repas_annules;
}
