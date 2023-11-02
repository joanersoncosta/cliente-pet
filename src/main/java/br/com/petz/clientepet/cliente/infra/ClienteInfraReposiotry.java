package br.com.petz.clientepet.cliente.infra;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.stereotype.Repository;

import br.com.petz.clientepet.cliente.application.repository.ClienteRepository;
import br.com.petz.clientepet.cliente.domain.Cliente;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;

@Repository
@Log4j2
@RequiredArgsConstructor
public class ClienteInfraReposiotry implements ClienteRepository {
	private final ClienteSpringDataJpaRepository clienteSpringDataJpaRepository;
	
	@Override
	public Cliente salva(Cliente cliente) {
		log.info("[inicia] ClienteInfraReposiotry - salva");
		clienteSpringDataJpaRepository.save(cliente);
		log.info("[finaliza] ClienteInfraReposiotry - salva");
		return cliente;
	}

	@Override
	public List<Cliente> buscaTodosClientes() {
		log.info("[inicia] ClienteInfraReposiotry - buscaTodosClientes");
		List<Cliente> clienteList = clienteSpringDataJpaRepository.findAll();
		log.info("[finaliza] ClienteInfraReposiotry - buscaTodosClientes");
		return clienteList;
	}

	@Override
	public Optional<Cliente> buscaClientePorId(UUID idCliente) {
		log.info("[inicia] ClienteInfraReposiotry - buscaClientePorId");
		Optional<Cliente> cliente = clienteSpringDataJpaRepository.findById(idCliente);
		log.info("[finaliza] ClienteInfraReposiotry - buscaClientePorId");
		return cliente;
	}

	@Override
	public void deletaClientePorId(Cliente cliente) {
		log.info("[inicia] ClienteInfraReposiotry - deletaClientePorId");
		clienteSpringDataJpaRepository.delete(cliente);
		log.info("[finaliza] ClienteInfraReposiotry - deletaClientePorId");
	}

}
