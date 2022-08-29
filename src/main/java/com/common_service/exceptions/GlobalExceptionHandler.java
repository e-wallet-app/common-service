//package com.common_service.exceptions;
//
//import lombok.extern.slf4j.Slf4j;
//import org.springframework.core.Ordered;
//import org.springframework.core.annotation.Order;
//import org.springframework.http.HttpHeaders;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
//import org.springframework.lang.Nullable;
//import org.springframework.validation.FieldError;
//import org.springframework.web.bind.MethodArgumentNotValidException;
//import org.springframework.web.bind.annotation.ControllerAdvice;
//import org.springframework.web.bind.annotation.ExceptionHandler;
//import org.springframework.web.context.request.WebRequest;
//import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;
//
//import java.util.Arrays;
//import java.util.LinkedList;
//import java.util.List;
//
//@Slf4j
//@ControllerAdvice
//@Order(Ordered.HIGHEST_PRECEDENCE)
//public class GlobalExceptionHandler extends ResponseEntityExceptionHandler
//{
//    public static final String VALIDATION_ERROR = "validation_error";
//
//    @ExceptionHandler(value = {RuntimeException.class})
//    protected ResponseEntity<?> handleLimitReached(RuntimeException ex) {
//        ErrorResponse response = new ErrorResponse(VALIDATION_ERROR, ex.getMessage());
//        this.printStackTrace(ex);
//        return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
//    }
//
//    protected ResponseEntity<Object> handleMethodArgumentNotValid(
//            MethodArgumentNotValidException ex,
//            HttpHeaders headers,
//            HttpStatus status,
//            WebRequest request) {
//        ErrorResponse response = new ErrorResponse(VALIDATION_ERROR, "Request is not valid");
//        List<FieldError> fieldErrors = ex.getBindingResult().getFieldErrors();
//        List<ItemValidationError> validationErrors = new LinkedList<>();
//        fieldErrors.forEach((v) -> {
//            validationErrors.add(new ItemValidationError(v.getObjectName(), v.getField(), v.getRejectedValue(), v.getDefaultMessage()));
//        });
//        response.setErrorItems(validationErrors);
//
//        return this.handleExceptionInternal(ex, response, headers, status, request);
//    }
//
//    private void printStackTrace(Exception ex) {
//        StackTraceElement[] trace = ex.getStackTrace();
//        StringBuilder traceLines = new StringBuilder();
//        traceLines.append("Caused By: ").append(ex.fillInStackTrace()).append("\n");
//        Arrays.stream(trace).filter(f -> f.getClassName().contains("com.example.springbootdemo"))
//                .forEach(traceElement -> traceLines.append("\tat ").append(traceElement).append("\n"));
//        log.error(traceLines.toString());
//    }
//
//    @Override
//    protected ResponseEntity<Object> handleExceptionInternal(Exception ex, @Nullable Object body, HttpHeaders headers, HttpStatus status, WebRequest request) {
//        if (HttpStatus.INTERNAL_SERVER_ERROR.equals(status)) {
//            request.setAttribute("javax.servlet.error.exception", ex, 0);
//        }
//        if (body == null) {
//            body = new ErrorResponse(ex.getClass().getName(), ex.getMessage());
//        }
//        StackTraceElement[] trace = ex.getStackTrace();
//        StringBuilder traceLines = new StringBuilder();
//        traceLines.append("Caused By: ").append(ex.fillInStackTrace()).append("\n");
//        Arrays.stream(trace).filter(f -> f.getClassName().contains("com.ewallet.admin"))
//                .forEach(traceElement -> traceLines.append("\tat ").append(traceElement).append("\n"));
//        logger.error(traceLines);
//        return new ResponseEntity<>(body, headers, status);
//    }
//
//
//}
