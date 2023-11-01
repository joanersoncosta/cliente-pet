package br.com.petz.clientepet.cliente.application.api;

import java.time.LocalDate;
import java.util.UUID;

import org.hibernate.validator.constraints.br.CPF;

import br.com.petz.clientepet.cliente.domain.Cliente;
import br.com.petz.clientepet.cliente.domain.Sexo;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Value;

@Value
public class ClienteDetalhadoResponse{
	private UUID idCliente;
	@NotBlank
	private String nomeCompleto;
	@NotBlank
	@Email
	private String email;
	@NotBlank
	private String celular;
	private String telefone;
	private Sexo sexo;
	@NotNull
	private LocalDate dataNascimento;
	@CPF
	private String cpf;
	@NotNull
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
