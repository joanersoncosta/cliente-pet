package br.com.petz.clientepet.pet.domain;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.UUID;

import org.apache.el.parser.AstInteger;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
@Getter
@Entity
public class Pet {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "idPet", updatable = false, unique = true, nullable = false)
	private UUID idPet;
	@Column(name = "idCliente", updatable = false, unique = true, nullable = false)
	private UUID idCliente;
	@NotBlank
	private String nomePet;
	@NotNull
	@Enumerated(EnumType.STRING)
	private Porte porte;
	@NotNull
	@Enumerated(EnumType.STRING)
	private TipoPet tipo;
	private String microShip;
	@NotBlank
	private String raca;
	@NotNull
	@Enumerated(EnumType.STRING)
	private SexoPet sexo;
	private String pelagemCor;
	@NotNull
	private LocalDate dataNascimento;
	private String rga;
	private int peso;

	private LocalDateTime momentoDoDacastro;
	private LocalDateTime dataHoraDaultimaAlteracao;
	
}
