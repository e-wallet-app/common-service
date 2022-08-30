package com.ewallet.agent.entity;

import lombok.Data;
import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.UUID;

@Data
@Entity
@Table(name = "nid_card_info")
public class NidCardInfo implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
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
    private Date birthDate;

    @Column(name = "blood_group")
    private String bloodGroup;

    @Column(name = "address", columnDefinition = "TEXT")
    private String address;

    @OneToOne(mappedBy = "nidCardInfo")
    private Agent agent;

    @OneToOne(fetch = FetchType.LAZY,orphanRemoval = true, cascade = CascadeType.ALL)
    @JoinColumn(name = "photo_id", referencedColumnName = "id")
    private Attachment attachment;


}
