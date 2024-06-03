package com.bdeesorn_r.shopping_list.dto.response;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ResponseCommonDto {
    private String resultCode;
    private String resultContent;

    public ResponseCommonDto(String resultCode, String resultContent) {
        this.resultCode = resultCode;
        this.resultContent = resultContent;
    }
}
