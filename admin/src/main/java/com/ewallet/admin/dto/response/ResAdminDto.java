package com.ewallet.admin.dto.response;

import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
public class ResAdminDto
{
    private String id;
    private String fullName;
    private String userName;
    private String birthDate;
    private String role;
    private String address;
    private String nidNumber;
    private String phoneNumber;
    private String email;
    private String gender;
    private String createdAt;
    private String profileImagePath;
    private String status;
}
