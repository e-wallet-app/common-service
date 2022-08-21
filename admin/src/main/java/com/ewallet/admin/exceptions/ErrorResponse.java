package com.ewallet.admin.exceptions;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.*;

import java.time.OffsetDateTime;
import java.util.List;
@Getter
@Setter
@ToString
public class ErrorResponse
{
    @JsonFormat(pattern = "yyyy-MM-dd hh:mm:ss Z")
    private OffsetDateTime timestamp;
    private String error;
    private String message;
    private String error_details;
    private List<?> errorItems;

    public ErrorResponse()
    {
    }

    public ErrorResponse(String error, String message)
    {
        this.error = error;
        this.message = message;
    }

    public ErrorResponse(String error, String message, String error_details)
    {
        this.error = error;
        this.message = message;
        this.error_details = error_details;
    }

    public ErrorResponse(OffsetDateTime timestamp, String error, String message, String error_details)
    {
        this.timestamp = timestamp;
        this.error = error;
        this.message = message;
        this.error_details = error_details;
    }
}
