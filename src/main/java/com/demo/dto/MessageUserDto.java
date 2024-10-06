package com.demo.dto;

import com.demo.model.Merchant;
import com.demo.model.User;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class MessageUserDto {
    private String contentUser;
    private String SubjectUser;
    private Integer userId;
    private Integer merchantId;
}
