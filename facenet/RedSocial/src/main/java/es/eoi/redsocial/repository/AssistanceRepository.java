package es.eoi.redsocial.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.support.JpaRepositoryImplementation;
import org.springframework.stereotype.Repository;

import es.eoi.redsocial.entity.Assistance;
import es.eoi.redsocial.entity.Event;
import es.eoi.redsocial.entity.User;

@Repository
public interface AssistanceRepository extends JpaRepositoryImplementation<Assistance, Integer> {

	Assistance findByUserAndEvent(User user, Event event);
	
	// SELECT event_id, COUNT(*) FROM ASSISTANCE a WHERE a.assist = true GROUP BY a.event_id ORDER BY COUNT(*) DESC
	@Query("SELECT event, COUNT(a) FROM ASSISTANCE a WHERE a.assist = true GROUP BY a.event ORDER BY COUNT(a) DESC")
	List<Event> findBestEvents();

	// SELECT event_id, COUNT(*) FROM ASSISTANCE a WHERE a.assist = true GROUP BY a.event_id ORDER BY COUNT(*) ASC
	@Query("SELECT event, COUNT(a) FROM ASSISTANCE a WHERE a.assist = true GROUP BY a.event ORDER BY COUNT(a) ASC")
	List<Event> findWorstEvents();

	// SELECT a.USER_ID, COUNT(*) FROM ASSISTANCE a WHERE a.ASSIST = true GROUP BY a.USER_ID ORDER BY COUNT(*) DESC
	@Query("SELECT a.user, COUNT(a) FROM ASSISTANCE a WHERE a.assist = true GROUP BY a.user ORDER BY COUNT(a) DESC")
	List<User> findBestAssistanceUsers();

}
