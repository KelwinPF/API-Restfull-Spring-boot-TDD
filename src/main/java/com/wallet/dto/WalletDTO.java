package com.wallet.dto;

import javax.validation.constraints.NotNull;
import java.math.BigDecimal;

public class WalletDTO {

    private long  id;
    @NotNull
    private String name;
    @NotNull
    private BigDecimal value;

    public void setName(String s) {
        this.name = s;
    }
    public void setId(Long s){
        this.id = s;
    }
    public void setValue(BigDecimal value){
        this.value = value;
    }
    public String getName() {
        return this.name;
    }

    public Long getId(){
        return this.id;
    }

    public BigDecimal getValue(){
        return this.value;
    }
}
