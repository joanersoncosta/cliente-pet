package br.com.petz.clientepet.cliente.application.api;

import java.time.LocalDateTime;
import java.util.UUID;

import br.com.petz.clientepet.cliente.domain.Cliente;
import br.com.petz.clientepet.cliente.domain.Sexo;
import lombok.Value;

@Value
public class ClienteDetalhadoResponse{
	private UUID idCliente;
	private String nomeCompleto;
	private String email;
	private String celular;
	private String telefone;
	private Sexo sexo;
	private Boolean aceitaTermos;
	private LocalDateTime momentoDoDacastro;

	public ClienteDetalhadoResponse(Cliente cliente) {
		this.idCliente = cliente.getIdCliente();
		this.nomeCompleto = cliente.getNomeCompleto();
		this.email = cliente.getEmail();
		this.celular = cliente.getCelular();
		this.telefone = cliente.getTelefone();
		this.sexo = cliente.getSexo();
		this.aceitaTermos = cliente.getAceitaTermos();
		this.momentoDoDacastro = cliente.getMomentoDoDacastro();
	}
	
}
