package com.nelioalves.workshopmongo.controller.exception;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.http.HttpStatus;

import java.io.Serializable;

@NoArgsConstructor
@Getter
@Setter
public class StandardError implements Serializable {

    private Long timestamp;
    private HttpStatus status;
    private String error;
    private String message;
    private String path;

    public StandardError(Long timestamp, HttpStatus status, String error, String message, String path) {
        this.timestamp = timestamp;
        this.status = status;
        this.error = error;
        this.message = message;
        this.path = path;
    }

}