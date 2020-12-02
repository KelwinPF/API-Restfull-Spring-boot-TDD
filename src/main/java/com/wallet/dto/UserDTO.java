package com.wallet.dto;

import com.fasterxml.jackson.annotation.JsonInclude;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class UserDTO {

    private Long id;
    @Email(message="Email inválido")
    private String email;
    private String name;
    @NotNull
    private String password;

    public void setEmail(String s) {
        this.email = s;
    }
    public void setPassword(String s) {
        this.password = s;
    }
    public void setName(String s) {
        this.name = s;
    }
    public void setId(Long s) {
        this.id = s;
    }

    public String getEmail() {
        return this.email;
    }

    public String getName() {
        return this.name;
    }

    public String getPassword() {
        return this.password;
    }
    public Long getId() {
        return this.id;
    }
}
