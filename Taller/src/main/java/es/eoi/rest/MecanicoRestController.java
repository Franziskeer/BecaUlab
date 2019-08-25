package es.eoi.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import es.eoi.model.Mecanico;
import es.eoi.model.Vehiculo;
import es.eoi.services.MecanicoService;

@RestController
public class MecanicoRestController {

	@Autowired
	private MecanicoService service;
	
	@GetMapping("/mecanicos")
	public List<Mecanico> findAll() {
		return service.findAll();
	}

	@PostMapping("/mecanico")
	public void newMecanico(@RequestBody Mecanico newMec) {
		service.newMecanico(newMec);
	}

	@GetMapping("/mecanicos/{id}")
	public Mecanico findMecanicoById(@PathVariable String id) {
		return service.findMecanicoById(id);
	}

	@PutMapping("/mecanicos/{id}")
	public void updateMecanico(@PathVariable String id, @RequestBody Vehiculo myVeh) {
		service.updateVehiculo(id, myVeh);
	}

	@DeleteMapping("/mecanicos/{id}")
	public void deleteMecanicoById(@PathVariable String id) {
		service.deleteMecanicoById(id);
	}
	
	@PostMapping("/mecanicos/{id}/{plaza}")
	public void asignAparcamiento(@PathVariable String id, @PathVariable Integer plaza) {
		service.asignAparcamiento(id, plaza);
	}
}
