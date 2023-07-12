package br.com.projeto.APiClientes.dtos;

import br.com.projeto.APiClientes.models.Cliente;
import br.com.projeto.APiClientes.models.enums.Status;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

public record ClienteRecord(
        @NotBlank(message = "Nome é obrigatório")
        String nome,
        @NotBlank(message = "Telefone é obrigatório")
        String telefone,
        @Email
        @NotBlank(message = "Email é obrigatório")
        String email,
        Status status) {

    public ClienteRecord(Cliente cliente) {
        this(cliente.getNome(), cliente.getEmail(), cliente.getTelefone(), cliente.getStatus());
    }


}
