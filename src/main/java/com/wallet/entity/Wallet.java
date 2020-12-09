package com.wallet.entity;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.math.BigDecimal;

@Entity
@Data
public class Wallet implements Serializable {
    private static final long serialVersionUID= -6079769300175684582L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
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
