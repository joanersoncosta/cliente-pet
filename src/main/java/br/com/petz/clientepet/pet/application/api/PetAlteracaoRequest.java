package br.com.petz.clientepet.pet.application.api;

import java.time.LocalDate;

import br.com.petz.clientepet.pet.domain.Porte;
import br.com.petz.clientepet.pet.domain.SexoPet;
import br.com.petz.clientepet.pet.domain.TipoPet;
import lombok.Getter;

@Getter
public class PetAlteracaoRequest {
	private String nomePet;
	private Porte porte;
	private TipoPet tipo;
	private String microShip;
	private String raca;
	private SexoPet sexo;
	private String pelagemCor;
	private LocalDate dataNascimento;
	private String rga;
	private int peso;
}
