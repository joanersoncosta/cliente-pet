package br.com.petz.clientepet.pet.application.service;

import java.util.List;
import java.util.UUID;

import br.com.petz.clientepet.pet.application.api.PetClienteListResponse;
import br.com.petz.clientepet.pet.application.api.PetDetalhadoResponse;
import br.com.petz.clientepet.pet.application.api.PetIdResponse;
import br.com.petz.clientepet.pet.application.api.PetRequest;

public interface PetService {
	PetIdResponse criaPet(UUID idCliente, PetRequest petRequest);
	List<PetClienteListResponse> buscaPetsDoCliente(UUID idCliente);
	PetDetalhadoResponse buscaPetDoCliente(UUID idCliente, UUID idPet);

}
