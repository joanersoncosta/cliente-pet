package br.com.petz.clientepet.pet.application.service;

import java.util.UUID;

import org.springframework.stereotype.Service;

import br.com.petz.clientepet.pet.application.api.PetIdResponse;
import br.com.petz.clientepet.pet.application.api.PetRequest;
import lombok.extern.log4j.Log4j2;

@Service
@Log4j2
public class PetApplicationService implements PetService {

	@Override
	public PetIdResponse criaPet(UUID idCliente, PetRequest petRequest) {
		log.info("[inicia] PetApplicationService - criaPet");
		log.info("[idCliente] {}", idCliente);
		
		log.info("[finaliza] PetApplicationService - criaPet");
		return  null;
	}

}
