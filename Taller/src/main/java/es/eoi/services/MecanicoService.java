package es.eoi.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import es.eoi.model.Mecanico;
import es.eoi.model.Vehiculo;
import es.eoi.repositories.MecanicoRepository;

@Service
public class MecanicoService {

	@Autowired
	private MecanicoRepository repository;

	public List<Mecanico> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	public void newMecanico(Mecanico newMec) {
		// TODO Auto-generated method stub
		
	}

	public Mecanico findMecanicoById(String id) {
		// TODO Auto-generated method stub
		return null;
	}

	public void updateVehiculo(String id, Vehiculo myVeh) {
		// TODO Auto-generated method stub
		
	}

	public void deleteMecanicoById(String id) {
		// TODO Auto-generated method stub
		
	}

	public void asignAparcamiento(String id, Integer plaza) {
		// TODO Auto-generated method stub
		
	}
	
}
