package br.com.petz.clientepet.pet.application.api;

import java.util.UUID;

import lombok.Builder;
import lombok.Value;

@Builder
@Value
public class PetIdResponse {
	private UUID idPet;
}
