package com.ewallet.admin.dto.request;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
public class ReqAdminDto
{
    private String fullName;
    private String userName;
    private LocalDate birthDate;
    private String role;
    private String address;
    private Long nidNumber;
    private Long phoneNumber;
    private String email;
    private String gender;
    private String profileImagePath;
}
