package com.ewallet.admin.entity;

import com.ewallet.admin.enums.Gender;
import com.ewallet.admin.enums.Role;
import com.ewallet.admin.enums.Status;
import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Data
@Entity
@Table(name = "admin_tbl")
public class Admin implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "full_name")
    private String fullName;

    @Column(name = "user_name")
    private String userName;

    @Column(name = "birth_date")
    private Date birthDate;

    @Enumerated(EnumType.STRING)
    @Column(name = "role")
    private Role role;

    @Column(name = "address")
    private String address;

    @Column(name = "nid_number")
    private Long nidNumber;

    @Column(name = "phn_number")
    private Long phoneNumber;

    @Column(name = "email")
    private String email;

    @Enumerated(EnumType.STRING)
    @Column(name = "gender")
    private Gender gender;

    @Column(name = "profile_photo")
    @OneToOne(fetch = FetchType.LAZY, orphanRemoval = true)
    private Attachment profilePhoto;

    @Enumerated(EnumType.STRING)
    @Column(name = "acc_status")
    private Status status;

    @Column(name = "created_at")
    private Date createdAt;
}
