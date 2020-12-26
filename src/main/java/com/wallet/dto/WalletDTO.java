package com.wallet.dto;

import lombok.Data;

import javax.validation.constraints.NotNull;
import java.math.BigDecimal;

@Data
public class WalletDTO {

    private Long id;
    @NotNull
    private String name;
    @NotNull
    private BigDecimal value;

}
