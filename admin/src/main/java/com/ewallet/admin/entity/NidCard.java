package com.ewallet.admin.entity;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.UUID;

@Data
@Entity
@Table(name = "nid_cards")
public class NidCard implements Serializable
{

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    @Column(name = "full_name_bn")
    private String fullNameBn;

    @Column(name = "full_name")
    private String fullName;

    @Column(name = "father_name")
    private String fatherName;

    @Column(name = "mother_name")
    private String motherName;

    @Column(name = "nid_number")
    private String nidNumber;

    @Column(name = "birth_date")
    private LocalDate birthDate;

    @Column(name = "blood_grp")
    private String bloodGroup;

    @Column(name = "address", columnDefinition = "text")
    private String address;

    @OneToOne(fetch = FetchType.LAZY,orphanRemoval = true)
    @JoinColumn(name = "nid_photo")
    private Attachment nidPhoto;
}
