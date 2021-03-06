package com.es.eoi.controller;

import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.es.eoi.dto.ClienteDto;
import com.es.eoi.entity.Cliente;
import com.es.eoi.service.ClienteService;

@RestController
public class ClientRestController {

	@Autowired
	ClienteService service;

	@GetMapping("/cliente/{id}")
	public Cliente findCliente(@PathVariable String id) {
		return service.findByNif(id);
	}

	@PostMapping("/cliente")
	public void updateCliente(@RequestBody ClienteDto clienteDto) {
		Cliente cliente = new Cliente();
		BeanUtils.copyProperties(clienteDto, cliente);
		service.save(cliente);
	}

	@DeleteMapping("/cliente/{id}")
	public void deleteCliente(@PathVariable String id) {
		service.remove(id);
	}

	@GetMapping("/cliente/all")
	public List<Cliente> findAll() {
		return service.findAll();
	}

}
