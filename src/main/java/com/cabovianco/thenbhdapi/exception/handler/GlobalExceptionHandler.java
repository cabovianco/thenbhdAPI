package com.cabovianco.thenbhdapi.exception.handler;

import com.cabovianco.thenbhdapi.exception.AlbumNotFoundException;
import com.cabovianco.thenbhdapi.exception.SongNotFoundException;
import com.cabovianco.thenbhdapi.exception.response.ExceptionResponse;
import com.cabovianco.thenbhdapi.exception.response.ValidationExceptionResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageConversionException;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.ArrayList;
import java.util.List;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(MethodArgumentNotValidException.class)
    ResponseEntity<ValidationExceptionResponse> handleValidationException(MethodArgumentNotValidException ex) {
        List<String> errors = new ArrayList<>();
        for (FieldError error : ex.getFieldErrors())
            errors.add(error.getDefaultMessage());

        return ResponseEntity
                .status(HttpStatus.BAD_REQUEST)
                .body(ValidationExceptionResponse.builder().errors(errors).build());
    }

    @ExceptionHandler(SongNotFoundException.class)
    ResponseEntity<ExceptionResponse> handleSongNotFoundException(SongNotFoundException ex) {
        return ResponseEntity
                .status(HttpStatus.NOT_FOUND)
                .body(ExceptionResponse.builder().message(ex.getMessage()).build());
    }

    @ExceptionHandler(AlbumNotFoundException.class)
    ResponseEntity<ExceptionResponse> handleAlbumNotFoundException(AlbumNotFoundException ex) {
        return ResponseEntity
                .status(HttpStatus.NOT_FOUND)
                .body(ExceptionResponse.builder().message(ex.getMessage()).build());
    }

    @ExceptionHandler(HttpMessageConversionException.class)
    ResponseEntity<ExceptionResponse> handleHttpMessageConversionException() {
        return ResponseEntity
                .status(HttpStatus.BAD_REQUEST)
                .body(ExceptionResponse.builder().message("Invalid request format.").build());
    }

}
