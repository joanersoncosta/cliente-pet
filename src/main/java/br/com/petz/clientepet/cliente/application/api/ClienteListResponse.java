package br.com.petz.clientepet.cliente.application.api;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

import br.com.petz.clientepet.cliente.domain.Cliente;
import lombok.Value;

@Value
public class ClienteListResponse {
	private UUID idCliente;
	private String nomeCompleto;
	private String email;
	private String cpf;
	private String celular;

	public ClienteListResponse(Cliente cliente) {
		this.idCliente = cliente.getIdCliente();
		this.nomeCompleto = cliente.getNomeCompleto();
		this.email = cliente.getEmail();
		this.cpf = cliente.getCpf();
		this.celular = cliente.getCelular();
	}

	public static List<ClienteListResponse> converte(List<Cliente> list) {
		return list.stream().map(ClienteListResponse::new).collect(Collectors.toList());
	}

}
