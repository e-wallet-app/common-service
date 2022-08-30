package com.ewallet.agent.exceptions;

import lombok.Data;

@Data
public class AgentNotFoundException extends RuntimeException{
    public AgentNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }

    public AgentNotFoundException(String message) {
        super(message);
    }

    public AgentNotFoundException(Throwable cause) {
        super(cause);
    }
}
