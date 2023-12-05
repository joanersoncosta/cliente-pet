package br.com.petz.clientepet.pet.application.service;

import java.util.List;
import java.util.UUID;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import br.com.petz.clientepet.cliente.application.api.ClienteDetalhadoResponse;
import br.com.petz.clientepet.cliente.application.service.ClienteService;
import br.com.petz.clientepet.handler.APIException;
import br.com.petz.clientepet.pet.application.api.PetClienteListResponse;
import br.com.petz.clientepet.pet.application.api.PetDetalhadoResponse;
import br.com.petz.clientepet.pet.application.api.PetIdResponse;
import br.com.petz.clientepet.pet.application.api.PetRequest;
import br.com.petz.clientepet.pet.application.repository.PetRepository;
import br.com.petz.clientepet.pet.domain.Pet;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;

@Service
@RequiredArgsConstructor
@Log4j2
public class PetApplicationService implements PetService {
	private final ClienteService clienteService;
	private final PetRepository petRepository;

	@Override
	public PetIdResponse criaPet(UUID idCliente, PetRequest petRequest) {
		log.info("[inicia] PetApplicationService - criaPet");
		log.info("[idCliente] {}", idCliente);
		clienteService.buscaClientePorId(idCliente);
		Pet pet = petRepository.salvaPet(new Pet(idCliente, petRequest));
		log.info("[finaliza] PetApplicationService - criaPet");
		return PetIdResponse.builder().idPet(pet.getIdPet()).build();
	}

	@Override
	public List<PetClienteListResponse> buscaPetsDoCliente(UUID idCliente) {
		log.info("[inicia] PetApplicationService - buscaPetsDoCliente");
		log.info("[idCliente] {}", idCliente);
		clienteService.buscaClientePorId(idCliente);
		List<Pet> petsDoCliente = petRepository.buscaPetsDoCliente();
		log.info("[finaliza] PetApplicationService - buscaPetsDoCliente");
		return PetClienteListResponse.converte(petsDoCliente);
	}

	@Override
	public PetDetalhadoResponse buscaPetDoCliente(UUID idCliente, UUID idPet) {
		log.info("[inicia] PetApplicationService - buscaPetDoCliente");
		log.info("[idCliente] {}, [idCliente] {}", idCliente, idPet);
		clienteService.buscaClientePorId(idCliente);
		Pet pet = petRepository.buscaPetDoCliente(idPet).orElseThrow(
				() -> APIException.build(HttpStatus.NOT_FOUND, "Pet não encontrado!"));
		log.info("[finaliza] PetApplicationService - buscaPetDoCliente");
		return new PetDetalhadoResponse(pet);
	}

	@Override
	public void deletaPetPorId(UUID idCliente, UUID idPet) {
		log.info("[inicia] PetApplicationService - deletaPetPorId");
		log.info("[idCliente] {}, [idCliente] {}", idCliente, idPet);
		ClienteDetalhadoResponse cliente = clienteService.buscaClientePorId(idCliente);
		Pet pet = petRepository.buscaPetDoCliente(idPet).orElseThrow(
				() -> APIException.build(HttpStatus.NOT_FOUND, "Pet não encontrado!"));
		pet.pertenceUsuario(cliente);
		petRepository.deletaPetPorId(idPet);
		log.info("[finaliza] PetApplicationService - deletaPetPorId");
	}

}
