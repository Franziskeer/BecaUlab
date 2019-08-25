package es.eoi.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import es.eoi.model.Vehiculo;
import es.eoi.repositories.VehiculoRepository;

@Service
public class VehiculoService {

	@Autowired
	private VehiculoRepository repository;
	
	public List<Vehiculo> findAll() {
		return repository.findAll();
	}

	public Vehiculo findVehiculoById(String id) {
		return repository.findById(id).get();
	}
	
}
