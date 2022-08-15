package com.ewallet.agent.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "nid_card_info")
public class NidCardInfo implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private Long id;

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
    private Date birthDate;

    @Column(name = "blood_group")
    private String bloodGroup;

    @Column(name = "address")
    private String address;


}
