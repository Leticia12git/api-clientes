package br.com.projeto.APiClientes.models;

import br.com.projeto.APiClientes.models.enums.Status;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serial;
import java.io.Serializable;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "Cliente")
@Table(name = "cliente")
public class Cliente implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    @Size(max=100)

    private String nome;
    @NotBlank
    private String telefone;
    @NotBlank
    @Size(max=100)
    private String email;
    @Enumerated(EnumType.STRING)
    private Status status;
}
