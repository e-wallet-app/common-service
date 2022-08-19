package com.ewallet.admin.entity;

import com.ewallet.admin.enums.Gender;
import com.ewallet.admin.enums.Role;
import com.ewallet.admin.enums.Status;
import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.UUID;

@Data
@Entity
@Table(name = "admin")
public class Admin implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private UUID id;

    @Column(name = "full_name")
    private String fullName;

    @Column(name = "user_name")
    private String userName;

    @Column(name = "birth_date")
    private LocalDate birthDate;

    @Enumerated(EnumType.STRING)
    @Column(name = "role")
    private Role role;

    @Column(name = "address", columnDefinition = "TEXT")
    private String address;

    @OneToOne(fetch = FetchType.LAZY,orphanRemoval = true)
    @JoinColumn(name = "nid_number",referencedColumnName = "id")
    private NidCard nidNumber;

    @Column(name = "phone_number")
    private String phoneNumber;

    @Column(name = "email")
    private String email;

    @Column(name = "password")
    private String password;

    @Enumerated(EnumType.STRING)
    @Column(name = "gender")
    private Gender gender;

    @JoinColumn(name = "profile_image", referencedColumnName = "id")
    @OneToOne(fetch = FetchType.LAZY, orphanRemoval = true)
    private Attachment profileImage;

    @Enumerated(EnumType.STRING)
    @Column(name = "account_status")
    private Status status;

    @Column(name = "created_at")
    private LocalDateTime createdAt;
}
