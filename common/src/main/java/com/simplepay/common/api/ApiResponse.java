package com.simplepay.common.api;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class ApiResponse<T> {

    private boolean success;
    private Integer resultCode;
    private String resultMessage;
    private String resultDescription;
    private T data;

    public static <T> ApiResponse<T> OK(T data, String resultDescription) {
        var code = ResponseCode.OK;

        return ApiResponse.<T>builder()
            .success(true)
            .resultCode(code.getResponseCode())
            .resultMessage(code.getDescription())
            .resultDescription(
                resultDescription == null ? "요청 성공" : resultDescription
            )
            .data(data)
            .build();
    }

    public static <T> ApiResponse<T> OK() {
        return OK(null, null);
    }

    public static <T> ApiResponse<T> OK(T data) {
        return OK(data, null);
    }

    public static <T> ApiResponse<T> OK(String resultDescription) {
        return OK(null, resultDescription);
    }

    public static <T> ApiResponse<T> ERROR(ResponseCodeIfs responseCodeIfs, T data, String resultDescription) {
        return ApiResponse.<T>builder()
            .success(false)
            .resultCode(responseCodeIfs.getResponseCode())
            .resultMessage(responseCodeIfs.getDescription())
            .resultDescription(
                resultDescription == null ? "에러 발생" : resultDescription
            )
            .data(data)
            .build();
    }

    public static <T> ApiResponse<T> ERROR(ResponseCodeIfs responseCodeIfs) {
        return ERROR(responseCodeIfs, null, null);
    }

    public static <T> ApiResponse<T> ERROR(ResponseCodeIfs responseCodeIfs, String resultDescription) {
        return ERROR(responseCodeIfs, null, resultDescription);
    }

    public static <T> ApiResponse<T> ERROR(ResponseCodeIfs responseCodeIfs, T data) {
        return ERROR(responseCodeIfs, data, null);
    }
}
