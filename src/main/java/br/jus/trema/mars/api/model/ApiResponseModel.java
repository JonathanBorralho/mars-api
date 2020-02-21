package br.jus.trema.mars.api.model;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class ApiResponseModel {
	
	private Map<String, JsonNode> properties = new HashMap<>();
	
	@JsonProperty("sol_keys")
	private List<String> keys;
	
	@JsonAnySetter
	public void set(String fieldName, JsonNode value) {
		this.properties.put(fieldName, value);
	}
	
	public List<Sol> getSols() {
		return keys.stream()
			.map(k -> new SolNodeWrapper(k, properties.get(k)))
			.map(ApiResponseModel::mapToSol)
			.collect(Collectors.toList());
	}
	
	private static Sol mapToSol(SolNodeWrapper nodeWrapper) {
		ObjectMapper mapper = new ObjectMapper();
		try {
			Sol sol = mapper.readValue(nodeWrapper.getNode().toString(), Sol.class);
			sol.setSol(nodeWrapper.getSol());
			return sol;
		} catch (Exception e) {
			return null;
		}
	}
	
}

@AllArgsConstructor
@Data
class SolNodeWrapper {
	private String sol;
	private JsonNode node;
}

