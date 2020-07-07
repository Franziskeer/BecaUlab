package es.eoi.redsocial.repository;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import es.eoi.redsocial.entity.Event;
import es.eoi.redsocial.entity.User;

@Repository
public interface EventRepository extends JpaRepository<Event, Integer> {

	List<Event> findByEventDateGreaterThan(Date fechaActual);
	
	List<Event> findByEventDateBetween(Date fechaInicio, Date fechaFinal);

	// SELECT e.CREATOR_USER_ID, COUNT(*) FROM EVENT e GROUP BY e.CREATOR_USER_ID ORDER BY COUNT(*) DESC
	@Query("SELECT e.creatorUser, COUNT(e) FROM EVENT e GROUP BY e.creatorUser ORDER BY COUNT(e) DESC")
	List<User> findBestActiveUsers();
	
}
