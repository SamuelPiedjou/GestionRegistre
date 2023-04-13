package com.gestionregistre.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@JsonIgnoreProperties(ignoreUnknown = true)
@Data
@RequiredArgsConstructor
public class ApiResponseDTO<T> {
    private String errorCode;
    private String returnType;
    private String returnMsg;
    private T returnValue;
    private String sessionId;
    private String context;
    private String trxId;
    private Boolean success;
    private Boolean failure;
    private Integer nbPages;


    public ApiResponseDTO(String errorCode, String returnMsg, T returnValue, Boolean success, Boolean failure) {
        super();
        this.errorCode = errorCode;
        this.returnMsg = returnMsg;
        this.returnValue = returnValue;
        this.success = success;
        this.failure = failure;
    }

    public ApiResponseDTO(T t) {
        returnValue = t;
    }

    @Override
    public String toString() {
        return getReturnType() + " - " + getReturnMsg() + " - " + getReturnValue() + " - " + getSessionId() + " - "
                + getContext() + " - " + getTrxId() + " - " + getSuccess() + " - " + getFailure() + " - " + getNbPages()
                + "-" + getErrorCode();

    }
}
