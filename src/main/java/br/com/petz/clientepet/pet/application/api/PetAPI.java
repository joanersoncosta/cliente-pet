package br.com.petz.clientepet.pet.application.api;

import java.util.List;
import java.util.UUID;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import br.com.petz.clientepet.cliente.application.api.ClienteDetalhadoResponse;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/v1/cliente/{idCliente}/pet")
public interface PetAPI {

	@PostMapping
	@ResponseStatus(code = HttpStatus.CREATED)
	PetIdResponse postPet(@PathVariable(value = "idCliente") UUID idCliente, @RequestBody @Valid PetRequest petRequest);
	
	@GetMapping
	@ResponseStatus(code = HttpStatus.OK)
	List<PetClienteListResponse> getPetsDoCliente(@PathVariable(value = "idCliente") UUID idClient);

	@GetMapping(value = "/{idPet}")
	@ResponseStatus(value = HttpStatus.OK)
	PetDetalhadoResponse buscaPetPorId(@PathVariable(value = "idCliente") UUID idCliente, @PathVariable(value = "idPet") UUID idPet);

	@DeleteMapping(value = "/{idPet}")
	@ResponseStatus(value = HttpStatus.NO_CONTENT)
	void deletaPetPorId(@PathVariable(value = "idCliente") UUID idCliente, @PathVariable(value = "idPet") UUID idPet);
}
