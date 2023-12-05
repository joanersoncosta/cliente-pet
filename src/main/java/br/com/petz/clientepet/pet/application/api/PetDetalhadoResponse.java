package br.com.petz.clientepet.pet.application.api;

import java.time.LocalDate;
import java.util.UUID;

import br.com.petz.clientepet.pet.domain.Pet;
import br.com.petz.clientepet.pet.domain.TipoPet;
import lombok.Value;

@Value
public class PetDetalhadoResponse {
	private UUID idPet;
	private String nomePet;
	private TipoPet tipo;
	private String raca;
	private LocalDate dataNascimento;

	public PetDetalhadoResponse(Pet pet) {
		this.idPet = pet.getIdPet();
		this.nomePet = pet.getNomePet();
		this.tipo = pet.getTipo();
		this.raca = pet.getRaca();
		this.dataNascimento = pet.getDataNascimento();
	}
}
