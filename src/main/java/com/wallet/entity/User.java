package com.wallet.entity;

import lombok.Data;

import java.io.Serializable;
import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;

import com.wallet.util.RoleEnum;

@Entity
@Data
@Table(name="users")
public class User implements Serializable {

    private static final long serialVersionUID=1693850165739564098L;

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false)
    private String password;
    @Column(nullable = false)
    private String name;
    @Email(message="Email inválido")
    private String email;
    @NotNull
    @Enumerated(EnumType.STRING)
    private RoleEnum role;

    public void setRole(RoleEnum s) {
        this.role = s;
    }
    public void setEmail(String s) {
        this.email = s;
    }
    public void setPassword(String s) {
        this.password = s;
    }
    public void setName(String s) {
        this.name = s;
    }
    public void setId(Long s){
        this.id = s;
    }

    public String getEmail() {
        return this.email;
    }

    public String getName() {
        return this.name;
    }
    public RoleEnum getRole() {
        return this.role;
    }
    public String getPassword() {
        return this.password;
    }

    public Long getId(){
        return this.id;
    }

}
