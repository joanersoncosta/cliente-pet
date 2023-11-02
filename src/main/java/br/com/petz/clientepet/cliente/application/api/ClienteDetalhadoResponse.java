package br.com.petz.clientepet.cliente.application.api;

import java.time.LocalDate;
import java.util.UUID;

import br.com.petz.clientepet.cliente.domain.Cliente;
import br.com.petz.clientepet.cliente.domain.Sexo;
import jakarta.persistence.Id;
import lombok.Value;

@Value
public class ClienteDetalhadoResponse{
	@Id
	private UUID idCliente;
	private String nomeCompleto;
	private String email;
	private String celular;
	private String telefone;
	private Sexo sexo;
	private LocalDate dataNascimento;
	private String cpf;
	private Boolean aceitaTermos;
	
	public ClienteDetalhadoResponse(Cliente cliente) {
		this.idCliente = cliente.getIdCliente();
		this.nomeCompleto = cliente.getNomeCompleto();
		this.email = cliente.getEmail();
		this.celular = cliente.getCelular();
		this.telefone = cliente.getTelefone();
		this.sexo = cliente.getSexo();
		this.dataNascimento = cliente.getDataNascimento();
		this.cpf = cliente.getCpf();
		this.aceitaTermos = cliente.getAceitaTermos();
	}
	
}
