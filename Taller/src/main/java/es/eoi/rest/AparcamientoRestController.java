package es.eoi.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import es.eoi.model.Aparcamiento;
import es.eoi.model.Vehiculo;
import es.eoi.services.AparcamientoService;

@RestController
public class AparcamientoRestController {

	@Autowired
	private AparcamientoService service;
	
	@GetMapping("/parking")
	public List<Aparcamiento> findAll() {
		return service.findAll();
	}

	@PostMapping("/parking")
	public void newAparcamiento(@RequestBody Aparcamiento newPark) {
		service.newAparcamiento(newPark);
	}

	@GetMapping("/parking/{id}")
	public Aparcamiento findAparcamientoById(@PathVariable Integer id) {
		return service.findAparcamientoById(id);
	}
	
}
