package br.com.petz.clientepet.cliente.application.repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import br.com.petz.clientepet.cliente.domain.Cliente;

public interface ClienteRepository {
	Cliente salva(Cliente cliente);
	List<Cliente> buscaTodosClientes();
	Optional<Cliente> buscaClientePorId(UUID idCliente);
}
