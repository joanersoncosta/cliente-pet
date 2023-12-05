package br.com.petz.clientepet.pet.infra;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.stereotype.Repository;

import br.com.petz.clientepet.pet.application.repository.PetRepository;
import br.com.petz.clientepet.pet.domain.Pet;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;

@Repository
@Log4j2
@RequiredArgsConstructor
public class PetInfraRepository implements PetRepository {
	private final PetSpringDataJPARepository petSpringDataJPARepository;

	@Override
	public Pet salvaPet(Pet pet) {
		log.info("[inicia] PetInfraRepository - salvaPet");
		petSpringDataJPARepository.save(pet);
		log.info("[finaliza] PetInfraRepository - salvaPet");
		return pet;
	}

	@Override
	public List<Pet> buscaPetsDoCliente() {
		log.info("[inicia] PetInfraRepository - buscaPetsDoCliente");
		var pets = petSpringDataJPARepository.findAll();
		log.info("[finaliza] PetInfraRepository - buscaPetsDoCliente");
		return pets;
	}

	@Override
	public Optional<Pet> buscaPetDoCliente(UUID idPet) {
		log.info("[inicia] PetInfraRepository - buscaPetDoCliente");
		var pet = petSpringDataJPARepository.findById(idPet);
		log.info("[finaliza] PetInfraRepository - buscaPetDoCliente");
		return pet;
	}

	@Override
	public void deletaPetPorId(UUID idPet) {
		log.info("[inicia] PetInfraRepository - deletaPetPorId");
		petSpringDataJPARepository.deleteById(idPet);
		log.info("[finaliza] PetInfraRepository - deletaPetPorId");
	}
}
