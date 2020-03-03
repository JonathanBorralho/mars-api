package br.jus.trema.mars.api.model;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@JsonIgnoreProperties(ignoreUnknown = true)
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Sol implements Serializable {
	
	private static final long serialVersionUID = -220403754986960561L;

	private String sol;
	
	@JsonProperty("AT")
	private Temperature temperature;
}
