package com.example.spring.graal.vm.exceptions;

import java.time.LocalDateTime;

public record ExceptionResponse(String path, String message, int statusCode, LocalDateTime localDateTime) {
}