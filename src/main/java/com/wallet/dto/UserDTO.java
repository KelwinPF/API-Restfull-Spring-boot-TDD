package com.wallet.dto;

import com.fasterxml.jackson.annotation.JsonInclude;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class UserDTO {

    private Long id;
    @Email(message="Email inválido")
    private String email;
    private String name;
    @NotNull
    private String password;
    @NotNull(message = "Informe uma role de acesso")
    @Pattern(regexp="^(ROLE_ADMIN|ROLE_USER)$", message = "Para a role de acesso somente são aceitos os valores ROLE_ADMIN ou ROLE_USER")
    private String role;

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
    public void setRole(String s) {
        this.role = s;
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
    public String getRole() {
        return this.role;
    }
    public Long getId() {
        return this.id;
    }
}
