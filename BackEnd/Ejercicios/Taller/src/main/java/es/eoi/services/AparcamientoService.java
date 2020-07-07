package es.eoi.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import es.eoi.model.Aparcamiento;
import es.eoi.model.Vehiculo;
import es.eoi.repositories.AparcamientoRepository;

@Service
public class AparcamientoService {

	@Autowired
	private AparcamientoRepository repository;

	public List<Aparcamiento> findAll() {
		return repository.findAll();
	}

	public void newAparcamiento(Aparcamiento newPark) {
		repository.save(newPark);
	}

	public Aparcamiento findAparcamientoById(Integer id) {
		return repository.findById(id).get();
	}
	
}
