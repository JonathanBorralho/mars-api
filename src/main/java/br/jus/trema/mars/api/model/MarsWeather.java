package br.jus.trema.mars.api.model;

import java.util.List;

import lombok.Data;

@Data
public class MarsWeather {
	private List<Sol> sols;
}
