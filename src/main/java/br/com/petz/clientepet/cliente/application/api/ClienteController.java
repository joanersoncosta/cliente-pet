package br.com.petz.clientepet.cliente.application.api;

import java.util.List;
import java.util.UUID;

import org.springframework.web.bind.annotation.RestController;

import br.com.petz.clientepet.cliente.application.service.ClienteService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;

@RestController
@Log4j2
@RequiredArgsConstructor
public class ClienteController implements ClienteAPI {

	private final ClienteService clienteService;

	@Override
	public ClienteResponse postCliente(@Valid ClienteRequest clienteRequest) {
		log.info("[inicia] ClienteController - postCliente");
		ClienteResponse clienteCriado = clienteService.criaCliente(clienteRequest);
		log.info("[finaliza] ClienteController - postCliente");
		return clienteCriado;
	}

	@Override
	public List<ClienteListResponse> getTodosCliente() {
		log.info("[inicia] ClienteController - getTodosCliente");
		List<ClienteListResponse> clientes = clienteService.buscaTodosClientes();
		log.info("[finaliza] ClienteController - getTodosCliente");
		return clientes;
	}

	@Override
	public ClienteDetalhadoResponse buscaClientePorId(UUID idCliente) {
		log.info("[inicia] ClienteController - buscaClientePorId");
		log.info("[idCliente] {}", idCliente);
		ClienteDetalhadoResponse cliente = clienteService.buscaClientePorId(idCliente);
		log.info("[finaliza] ClienteController - buscaClientePorId");
		return cliente;
	}

	@Override
	public void deletaClientePorId(UUID idCliente) {
		log.info("[inicia] ClienteController - deletaClientePorId");
		log.info("[idCliente] {}", idCliente);
		clienteService.deletaClientePorId(idCliente);
		log.info("[finaliza] ClienteController - deletaClientePorId");
	}

	@Override
	public void patchClientePorId(ClienteAlteracaoRequest clienteRequest, UUID idCliente) {
		log.info("[inicia] ClienteController - patchClientePorId");
		log.info("[idCliente] {}", idCliente);
		clienteService.alteraClientePorId(clienteRequest, idCliente);
		log.info("[finaliza] ClienteController - patchClientePorId");
		
	}

}
