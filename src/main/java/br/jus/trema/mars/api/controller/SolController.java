package br.jus.trema.mars.api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.jus.trema.mars.api.model.Sol;
import br.jus.trema.mars.api.service.SolService;

@CrossOrigin("*")
@RestController
@RequestMapping("/sols")
public class SolController {
	
	@Autowired
	private SolService solService;
	
	@GetMapping
	public List<Sol> list() {
		return solService.findAll();
	}
}
