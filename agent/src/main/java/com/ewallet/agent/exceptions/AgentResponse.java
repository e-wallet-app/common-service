package com.ewallet.agent.exceptions;

import lombok.Data;

@Data
public class AgentResponse {
    private int status;
    private String message;
    private Long timeStamp;

    public AgentResponse(int status, String message, Long timeStamp) {
        this.status = status;
        this.message = message;
        this.timeStamp = timeStamp;
    }

    public AgentResponse() {

    }
}
