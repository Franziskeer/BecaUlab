package es.eoi.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import es.eoi.model.Mecanico;

@Repository
public interface MecanicoRepository extends JpaRepository<Mecanico, String> {

}
