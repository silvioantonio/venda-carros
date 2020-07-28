package com.silvio.plataforma.controller;

import java.util.List;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.silvio.plataforma.model.Veiculo;
import com.silvio.plataforma.service.VeiculoService;

@CrossOrigin
@RestController
@RequestMapping(value="/veiculos")
public class VeiculoController {

	@Autowired
	private VeiculoService veiculoService;
	
	@GetMapping
	public List<Veiculo> listarTodos(){
		return this.veiculoService.getRepository().findAll();
	}

	@GetMapping("/modelo/{modelo}")
	public List<Veiculo> buscarPorModelo(@PathVariable String modelo) {
		return this.veiculoService.buscaPorModelo(modelo);
	}
	
	@GetMapping("/marca/{marca}")
	public List<Veiculo> buscarPorMarca(@PathVariable String marca) {
		return this.veiculoService.buscaPorMarca(marca);
	}
	
	@PostMapping
	@PreAuthorize("hasRole('ADMIN')")
	public ResponseEntity<Veiculo> salvar (@Valid @RequestBody Veiculo v1, HttpServletResponse response)  {
		Veiculo v = this.veiculoService.getRepository().saveAndFlush(v1);
		return ResponseEntity.status(HttpStatus.CREATED).body(v);
	}
	
	@PutMapping
	@PreAuthorize("hasRole('ADMIN')")
	public ResponseEntity<Veiculo> atualizar (@Valid @RequestBody Veiculo veiculo, HttpServletResponse response)  {
		Veiculo v = this.veiculoService.getRepository().saveAndFlush(veiculo);
		return ResponseEntity.status(HttpStatus.OK).body(v);
	}
	
	@DeleteMapping("/{id}")
	@PreAuthorize("hasRole('ADMIN')")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void remover(@PathVariable Long id) {
		this.veiculoService.getRepository().deleteById(id);
	}
}
