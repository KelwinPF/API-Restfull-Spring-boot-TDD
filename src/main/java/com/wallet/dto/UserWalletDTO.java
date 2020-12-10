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

    public Long getUsers() {
        return this.users;
    }

    public Long getWallet(){return this.wallet;}

    public void setId(Long s){
        this.id = s;
    }
    public void setUsers(Long s){
        this.users = s;
    }
    public void setWallet(Long s){
        this.wallet = s;
    }

    public Long getId(){
        return this.id;
    }
}
