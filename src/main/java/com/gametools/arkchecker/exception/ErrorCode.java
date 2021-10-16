package com.gametools.arkchecker.exception;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonFormat.Shape;
import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.http.HttpStatus;

@AllArgsConstructor
@Getter
@JsonFormat(shape = Shape.OBJECT)
public enum ErrorCode {
    // common
    INVALID_TYPE_VALUE(HttpStatus.BAD_REQUEST.value(), "CM001", "Invalid Type Value"),

    // schedule
    ALREADY_COMPLETED_SCHEDULE(HttpStatus.BAD_REQUEST.value(), "S001", "이미 완료된 스케줄입니다"),

    // character
    CHARACTER_NOT_FOUND(HttpStatus.BAD_REQUEST.value(), "C001" ,"해당 캐릭터를 찾을 수 없습니다"),
    ;

    private final String code;
    private final String message;
    private int status;

    ErrorCode(final int status, final String code, final String message) {
        this.status = status;
        this.message = message;
        this.code = code;
    }

    public String getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }

    public int getStatus() {
        return status;
    }
}
