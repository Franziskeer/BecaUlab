package es.eoi.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import es.eoi.model.Aparcamiento;

@Repository
public interface AparcamientoRepository extends JpaRepository<Aparcamiento, Integer> {

}
