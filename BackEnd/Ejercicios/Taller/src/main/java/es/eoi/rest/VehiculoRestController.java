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

import es.eoi.model.Vehiculo;
import es.eoi.services.VehiculoService;

@RestController
public class VehiculoRestController {

	@Autowired
	VehiculoService service;

	@GetMapping("/vehiculos")
	public List<Vehiculo> findAll() {
		return service.findAll();
	}

	@PostMapping("/vehiculos")
	public void newVehiculo(@RequestBody Vehiculo newVeh) {
		service.newVehiculo(newVeh);
	}

	@GetMapping("/vehiculos/{id}")
	public Vehiculo findVehiculoById(@PathVariable String id) {
		return service.findVehiculoById(id);
	}

	@PutMapping("/vehiculos/{id}")
	public void updateVehiculo(@PathVariable String id, @RequestBody Vehiculo myVeh) {
		service.updateVehiculo(id, myVeh);
	}

	@DeleteMapping("/vehiculos/{id}")
	public void deleteVehiculoById(@PathVariable String id) {
		service.deleteVehiculoById(id);
	}

}
