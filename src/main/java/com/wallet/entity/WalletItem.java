package com.wallet.entity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

import com.wallet.util.TypeEnum;
import lombok.Data;

@Entity
@Table(name = "wallet_items")
@Data
public class WalletItem implements Serializable{

    /**
     *
     */
    private static final long serialVersionUID = 6079769300175684582L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @JoinColumn(name = "wallet", referencedColumnName = "id")
    @ManyToOne(fetch = FetchType.LAZY)
    private Wallet wallet;
    @NotNull
    private Date date;
    @NotNull
    @Enumerated(EnumType.STRING)
    private TypeEnum type;
    @NotNull
    private String description;
    @NotNull
    private BigDecimal value;

}