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

}
