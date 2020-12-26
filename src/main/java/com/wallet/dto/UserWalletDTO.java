package com.wallet.dto;

import com.wallet.entity.User;
import com.wallet.entity.Wallet;
import lombok.Data;

import javax.validation.constraints.NotNull;

@Data
public class UserWalletDTO {

    private Long id;
    @NotNull(message = "Informe o id do usuário")
    private Long users;
    @NotNull(message = "Informe o id da carteira")
    private Long wallet;

}
