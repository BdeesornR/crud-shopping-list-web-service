package com.bdeesorn_r.shopping_list.dto.request;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class RequestUserDto {
    private String username;
    private String email;
    private String password;
}
