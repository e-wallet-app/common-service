package com.ewallet.admin.dto.responseDto;

import com.ewallet.admin.enums.Gender;
import com.ewallet.admin.enums.Role;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
public class ResAdmin
{
    private Long id;
    private String fullName;
    private String userName;
    private Date birthDate;
    private Role role;
    private String address;
    private Long nidNumber;
    private Long phoneNumber;
    private String email;
    private Gender gender;
    private Date createdAt;
}
