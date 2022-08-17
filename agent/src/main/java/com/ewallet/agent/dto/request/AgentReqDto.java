package com.ewallet.agent.dto.request;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
public class AgentReqDto {

    private Long id;
    private String userName;
    private String displayName;
    private String fullName;
    private LocalDate birthDate;
    private String address;
    private Long phoneNumber;
    private String email;
    private String gender;
    private String pin;
    private String role;
    private String profileImagePath;
}
