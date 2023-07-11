package br.com.projeto.APiClientes.dtos;

import br.com.projeto.APiClientes.models.enums.Status;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

public record ClienteRecord(

        @NotBlank
        String nome,
        @NotBlank
        String telefone,
        @NotBlank
        @Email
        String email ,
        Status status){
}
