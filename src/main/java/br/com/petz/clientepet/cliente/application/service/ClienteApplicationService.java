package br.com.petz.clientepet.cliente.application.service;

import java.util.List;
import java.util.UUID;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import br.com.petz.clientepet.cliente.application.api.ClienteAlteracaoRequest;
import br.com.petz.clientepet.cliente.application.api.ClienteDetalhadoResponse;
import br.com.petz.clientepet.cliente.application.api.ClienteListResponse;
import br.com.petz.clientepet.cliente.application.api.ClienteRequest;
import br.com.petz.clientepet.cliente.application.api.ClienteResponse;
import br.com.petz.clientepet.cliente.application.repository.ClienteRepository;
import br.com.petz.clientepet.cliente.domain.Cliente;
import br.com.petz.clientepet.handler.APIException;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;

@Service
@Log4j2
@RequiredArgsConstructor
public class ClienteApplicationService implements ClienteService {
	private final ClienteRepository clienteRepository;

	@Override
	public ClienteResponse criaCliente(ClienteRequest clienteRequest) {
		log.info("[inicia] ClienteApplicationService - criaCliente");
		Cliente cliente = clienteRepository.salva(new Cliente(clienteRequest));
		log.info("[finaliza] ClienteApplicationService - criaCliente");
		return ClienteResponse.builder()
				.idCliente(cliente.getIdCliente())
				.build();
	}

	@Override
	public List<ClienteListResponse> buscaTodosClientes() {
		log.info("[inicia] ClienteApplicationService - buscaTodosClientes");
		List<Cliente> clienteListResponse = clienteRepository.buscaTodosClientes();
		log.info("[finaliza] ClienteApplicationService - buscaTodosClientes");
		return ClienteListResponse.converte(clienteListResponse);
	}

	@Override
	public ClienteDetalhadoResponse buscaClientePorId(UUID idCliente) {
		log.info("[inicia] ClienteApplicationService - buscaClientePorId");
		Cliente cliente = clienteRepository.buscaClientePorId(idCliente).orElseThrow(
				() -> APIException.build(HttpStatus.NOT_FOUND, "Cliente não encontrado!") );
		log.info("[finaliza] ClienteApplicationService - buscaClientePorId");
		return new ClienteDetalhadoResponse(cliente);
	}

	@Override
	public void deletaClientePorId(UUID idCliente) {
		log.info("[inicia] ClienteApplicationService - deletaClientePorId");
		Cliente cliente = clienteRepository.buscaClientePorId(idCliente).orElseThrow(
				() -> APIException.build(HttpStatus.NOT_FOUND, "Cliente não encontrado!") );
		clienteRepository.deletaClientePorId(cliente);
		log.info("[finaliza] ClienteApplicationService - deletaClientePorId");
	}

	@Override
	public void alteraClientePorId(ClienteAlteracaoRequest clienteRequest, UUID idCliente) {
		log.info("[inicia] ClienteApplicationService - alteraClientePorId");
		Cliente cliente = clienteRepository.buscaClientePorId(idCliente).orElseThrow(
				() -> APIException.build(HttpStatus.NOT_FOUND, "Cliente não encontrado!") );
		cliente.altera(clienteRequest);
		clienteRepository.salva(cliente);
		log.info("[finaliza] ClienteApplicationService - alteraClientePorId");
	}
}
