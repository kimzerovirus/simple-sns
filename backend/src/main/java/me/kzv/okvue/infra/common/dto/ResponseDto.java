package me.kzv.okvue.modules.common.dto;

import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.List;

@NoArgsConstructor
@ToString
public class ResponseDto<T> {
    private int status;
    private String message;
    private List<T> data;

    public ResponseDto(ResponseStatus status) {
        this.status = status.getCode();
        this.message = status.getMessage();
    }

    public ResponseDto(ResponseStatus status, List<T> data) {
        this.data = data;
        this.status = status.getCode();
        this.message = status.getMessage();
    }

    public static <T> ResponseDto<T> OK(List<T> data) {
        return new ResponseDto<>(ResponseStatus.OK, data);
    }

    public static <T> ResponseDto<T> setCode(ResponseStatus status){
        return new ResponseDto<>(status);
    }
}
