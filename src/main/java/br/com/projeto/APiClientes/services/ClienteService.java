package br.com.projeto.APiClientes.services;

import br.com.projeto.APiClientes.dtos.ClienteRecord;
import br.com.projeto.APiClientes.models.Cliente;
import br.com.projeto.APiClientes.repositories.ClienteRepository;
import jakarta.validation.ValidationException;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ClienteService {

    private final ModelMapper modelMapper;
    private final ClienteRepository clienteRepository;

    /**
     * metodo que busca todos os clientes
     *
     * @return Page<ClienteDTO>
     */
    public Page<Cliente> listarClientes(Pageable paginacao) {
        return clienteRepository.findAll(paginacao);
    }

    /**
     * metodo que busca um cliente por id
     *
     * @param id
     * @return Optional<ClienteDTO>
     */
    public Optional<Cliente> findById(Long id) {
        Cliente cliente = clienteRepository.findById(id).orElseThrow(RuntimeException::new);
        ClienteRecord dto = modelMapper.map(cliente, ClienteRecord.class);
        return clienteRepository.findById(id);
    }

    /**
     * metodo para cadastra um cliente
     *
     * @param clienteDTO
     * @return ClienteDTO
     */
    @Transactional(rollbackFor = Exception.class)
    public Cliente cadastrarCliente(ClienteRecord clienteDTO) throws ValidationException {
        Cliente cliente = modelMapper.map(clienteDTO, Cliente.class);
        clienteRepository.save(cliente);
        return modelMapper.map(cliente, Cliente.class);
    }


    /**
     * metodo para atualizar o cliente
     *
     * @param id
     * @param clienteDTO
     * @return ClienteDTO
     */

    @Transactional(rollbackFor = Exception.class)
    public ClienteRecord atualizarCliente(Long id, ClienteRecord clienteDTO) {
        Cliente cliente = modelMapper.map(clienteDTO, Cliente.class);
        cliente.setId(id);
        cliente = clienteRepository.findById(id).orElseThrow();
        return modelMapper.map(cliente, ClienteRecord.class);
    }

    /**
     * metodo utilizado para deletar um cliente por id
     *
     * @param id
     */
    public void deletarCliente(Long id) {
        clienteRepository.deleteById(id);
    }
}