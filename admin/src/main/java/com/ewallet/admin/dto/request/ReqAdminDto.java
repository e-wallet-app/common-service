package com.ewallet.admin.dto.request;

import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
public class ReqAdminDto
{
    private String fullName;
    private String userName;
    private String birthDate;
    private String role;
    private String address;
    private String nidNumber;
    private String phoneNumber;
    private String email;
    private String gender;
    private String profileImagePath;
}
