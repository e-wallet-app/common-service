package com.ewallet.agent.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "agent_wallet")
public class AgentWallet implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private UUID id;

    @Column(name = "wallet_number")
    private String walletNumber;

    @Column(name = "current_balance")
    private Double currentBalance;

    @Column(name = "deposit_balance")
    private Double  depositBalance;

    @OneToOne(mappedBy = "agentWallet")
    private Agent agent;
}
