package com.bdeesorn_r.shopping_list.dto.response;

import java.util.List;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ResponseCommonDto {
    private String resultCode;
    private Object resultContent;

    public ResponseCommonDto(String resultCode, String resultContent) {
        this.resultCode = resultCode;
        this.resultContent = resultContent;
    }

    public <T> ResponseCommonDto(String resultCode, List<T> resultContent) {
        this.resultCode = resultCode;
        this.resultContent = resultContent;
    }
}
