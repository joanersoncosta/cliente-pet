package br.com.petz.clientepet.pet.application.api;

import java.util.UUID;

import org.springframework.web.bind.annotation.RestController;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;

@RestController
@RequiredArgsConstructor
@Log4j2
public class PetRestController implements PetAPI {
	
	@Override
	public PetResponse postPet(UUID idCliente, @Valid PetRequest petRequest) {
		log.info("[inicia] PetRestController - postPet");
		log.info("[idCliente] {}", idCliente);

		log.info("[finaliza] PetRestController - postPet");

		return null;
	}

}
