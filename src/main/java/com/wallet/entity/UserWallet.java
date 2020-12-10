package com.wallet.entity;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name="users_wallet")
@Data
public class UserWallet implements Serializable {

    private static final long serialVersionUID= -8104860055249069590L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @JoinColumn(name="users",referencedColumnName = "id")
    @ManyToOne(fetch = FetchType.LAZY)
    private User users;
    @JoinColumn(name="wallet",referencedColumnName = "id")
    @ManyToOne(fetch = FetchType.LAZY)
    private Wallet wallet;

    public User getUsers() {
        return this.users;
    }
    public Long getId(){return this.id;}
    public Wallet getWallet(){return this.wallet;}

    public void setId(Long s){
        this.id = s;
    }
    public void setUsers(User u){this.users = u;}
    public void setWallet(Wallet w){this.wallet = w;}
}
