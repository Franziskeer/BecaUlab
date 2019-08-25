package es.eoi.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import es.eoi.model.Vehiculo;
import es.eoi.services.VehiculoService;

@RestController
public class VehiculoController {

	@Autowired
	VehiculoService service;
	
	@GetMapping("/vehiculo/all")
	public List<Vehiculo> findAll() {
		return service.findAll();
	}
	
	@GetMapping("/vehiculo/{id}")
	public Vehiculo findVehiculoById(@PathVariable String id) {
		return service.findVehiculoById(id);
	}
	
}
