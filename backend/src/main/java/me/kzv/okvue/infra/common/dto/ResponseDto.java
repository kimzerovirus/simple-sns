package me.kzv.okvue.infra.common.dto;

import lombok.NoArgsConstructor;
import lombok.ToString;
import org.springframework.http.ResponseEntity;

import java.util.List;

@NoArgsConstructor
@ToString
public class ResponseDto<T> {
    private int status;
    private String message;
    private T body;

    public ResponseDto(ResponseStatus status) {
        this.status = status.getCode();
        this.message = status.getMessage();
    }

    public ResponseDto(ResponseStatus status, T body) {
        this.body = body;
        this.status = status.getCode();
        this.message = status.getMessage();
    }

    /**
     * 응답 성공시
     */
    public static <T> ResponseEntity<ResponseDto<T>> OK(final T body){
        return ResponseEntity.ok(new ResponseDto<>(ResponseStatus.OK, body));
    }

    /**
     * 응답 실패시
     */
    public static <T> ResponseEntity<ResponseDto<T>> setCode(final ResponseStatus status){
        return ResponseEntity.ok(new ResponseDto<>(status));
    }
}
