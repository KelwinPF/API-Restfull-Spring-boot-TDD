package com.wallet.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

@JsonInclude(JsonInclude.Include.NON_NULL)
@Data
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
}
