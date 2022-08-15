package com.ewallet.agent.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "agent_wallet")
public class AgentWallet implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "wallet_number")
    private String walletNumber;

    @Column(name = "current_balance")
    private double currentBalance;

    @Column(name = "deposit_balance")
    private double  depositBalance;
}
