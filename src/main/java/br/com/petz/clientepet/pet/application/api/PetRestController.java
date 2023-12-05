package br.com.petz.clientepet.pet.application.api;

import java.util.List;
import java.util.UUID;

import org.springframework.web.bind.annotation.RestController;

import br.com.petz.clientepet.pet.application.service.PetService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;

@RestController
@RequiredArgsConstructor
@Log4j2
public class PetRestController implements PetAPI {
	private final PetService petService;
	
	@Override
	public PetIdResponse postPet(UUID idCliente, @Valid PetRequest petRequest) {
		log.info("[inicia] PetRestController - postPet");
		log.info("[idCliente] {}", idCliente);
		PetIdResponse petResponse = petService.criaPet(idCliente, petRequest);
		log.info("[finaliza] PetRestController - postPet");
		return petResponse;
	}

	@Override
	public List<PetClienteListResponse> getPetsDoCliente(UUID idCliente) {
		log.info("[inicia] PetRestController - getPetsDoCliente");
		log.info("[idCliente] {}", idCliente);
		List<PetClienteListResponse> petsDoCliente = petService.buscaPetsDoCliente(idCliente);
		log.info("[finaliza] PetRestController - getPetsDoCliente");
		return petsDoCliente;
	}

	@Override
	public PetDetalhadoResponse buscaPetPorId(UUID idCliente, UUID idPet) {
		log.info("[inicia] PetRestController - buscaPetPorId");
		log.info("[idCliente] {}", idCliente);
		PetDetalhadoResponse petResponse = petService.buscaPetDoCliente(idCliente, idPet);
		log.info("[finaliza] PetRestController - buscaPetPorId");
		return petResponse;
	}

	@Override
	public void deletaPetPorId(UUID idCliente, UUID idPet) {
		log.info("[inicia] PetRestController - deletaPetPorId");
		log.info("[idCliente] {}, [idPet] {}", idCliente, idPet);
		petService.deletaPetPorId(idCliente, idPet);
		log.info("[finaliza] PetRestController - deletaPetPorId");
	}

	@Override
	public void patchPetPorId(PetAlteracaoRequest petRequest, UUID idCliente, UUID idPet) {
		log.info("[inicia] PetRestController - patchPetPorId");
		log.info("[idCliente] {}, [idPet] {}", idCliente, idPet);
		log.info("[finaliza] PetRestController - patchPetPorId");
	}
}
