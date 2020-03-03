package br.jus.trema.mars.api.model;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@JsonIgnoreProperties(ignoreUnknown = true)
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Temperature implements Serializable {
	
	private static final long serialVersionUID = -2934303351776422215L;
	
	public Double av;
	public Double mn;
	public Double mx;
}