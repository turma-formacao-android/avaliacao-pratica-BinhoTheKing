package br.com.cast.turmaformacao.agenda.model.entities;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

public class PersonalAddress {
	@JsonIgnoreProperties(ignoreUnknown = true)
	@JsonProperty("cep")
	Integer cep;

	@JsonProperty("bairro")
	String neighborhood;

	@JsonProperty("cidade")
	String city;

	@JsonProperty("logradouro")
	String street;

	@JsonProperty("estado")
	String state;
}
