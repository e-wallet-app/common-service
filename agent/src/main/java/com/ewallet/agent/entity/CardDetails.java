package com.ewallet.agent.entity;

import com.ewallet.agent.enums.Status;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "card_details")
public class CardDetails implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private UUID id;

    @Column(name = "card_number")
    private String cardNumber;

    @Column(name = "expire_date")
    private Date expireDate;

    @Enumerated(EnumType.STRING)
    @Column(name = "account_status")
    private Status status;



}
