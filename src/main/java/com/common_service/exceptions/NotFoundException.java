package com.common_service.exceptions;

public class NotFoundException extends RuntimeException
{
    public NotFoundException(String s)
    {
        super(s);
    }
}
