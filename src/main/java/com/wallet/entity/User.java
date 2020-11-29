package com.wallet.entity;

import lombok.Data;

import javax.annotation.Generated;
import java.io.Serializable;
import javax.persistence.*;


@Entity
@Data
public class User implements Serializable {

    private static final long serialVersionUID=1693850165739564098L;

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false)
    private String password;
    @Column(nullable = false)
    private String name;
    private String email;

    public void setEmail(String s) {
        this.email = s;
    }
    public void setPassword(String s) {
        this.password = s;
    }
    public void setName(String s) {
        this.name = s;
    }

    public String getEmail() {
        return this.email;
    }

    public String getName() {
        return this.name;
    }
}
