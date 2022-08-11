package com.ewallet.admin.dto.response;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
public class ResAdminDto
{
    private Long id;
    private String fullName;
    private String userName;
    private Date birthDate;
    private String role;
    private String address;
    private String nidNumber;
    private String phoneNumber;
    private String email;
    private String gender;
    private String  createdAt;
    private String profileImagePath;
}
