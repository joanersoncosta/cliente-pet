package br.com.petz.clientepet.pet.application.service;

import java.util.UUID;

import br.com.petz.clientepet.pet.application.api.PetIdResponse;
import br.com.petz.clientepet.pet.application.api.PetRequest;

public interface PetService {
	PetIdResponse criaPet(UUID idCliente, PetRequest petRequest);

}
