package br.com.projeto.APiClientes.controllers;

import br.com.projeto.APiClientes.dtos.ClienteRecord;
import br.com.projeto.APiClientes.models.Cliente;
import br.com.projeto.APiClientes.services.ClienteService;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import jakarta.servlet.http.HttpServlet;
import jakarta.validation.Valid;
import jakarta.validation.ValidationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.util.Optional;

@RestController
@RequestMapping("/clientes")
public class ClienteController extends HttpServlet {


    @Autowired
    ClienteService clienteService;


    @GetMapping
    public ResponseEntity<Page<Cliente>> listarClientes(@PageableDefault(size = 10, sort = {"nome"}) Pageable paginacao) {
        var page = clienteService.listarClientes(paginacao);
        return ResponseEntity.ok(page);
    }

    @GetMapping(value = "/{id}")
    public Optional<Cliente> buscarPoId(@PathVariable Long id) {
        return clienteService.findById(id);
    }

    @PostMapping
    @Transactional
    public ResponseEntity cadastrar(@RequestBody @Valid ClienteRecord clienteDTO, UriComponentsBuilder uriBuilder) throws ValidationException {
        Cliente cliente = clienteService.cadastrarCliente(clienteDTO);
        URI endereco = uriBuilder.path("/clientes").buildAndExpand().toUri();
        return ResponseEntity.created(endereco).body(cliente);
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<ClienteRecord> atualizar(@PathVariable Long id, @RequestBody @Valid ClienteRecord clienteRecord) {
        ClienteRecord atualizado = clienteService.atualizarCliente(id, clienteRecord);
        return ResponseEntity.ok(atualizado);

    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<ClienteRecord> deletar(@PathVariable Long id) {
        clienteService.deletarCliente(id);
        return ResponseEntity.noContent().build();
    }
}
