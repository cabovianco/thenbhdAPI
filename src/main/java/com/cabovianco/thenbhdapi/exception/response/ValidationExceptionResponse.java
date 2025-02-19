package com.cabovianco.thenbhdapi.exception.response;

import lombok.Builder;
import lombok.Getter;

import java.util.List;

@Builder
@Getter
public class ValidationExceptionResponse {

    private List<String> errors;

}
