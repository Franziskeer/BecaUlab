package es.eoi.redsocial.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.support.JpaRepositoryImplementation;
import org.springframework.stereotype.Repository;

import es.eoi.redsocial.entity.Message;
import es.eoi.redsocial.entity.User;

@Repository
public interface MessageRepository extends JpaRepositoryImplementation<Message, Integer> {

	// SELECT e.CREATOR_USER_ID, COUNT(*) FROM EVENT e GROUP BY e.CREATOR_USER_ID ORDER BY COUNT(*) DESC
	@Query("SELECT m.creatorUser, COUNT(m) FROM MESSAGE m GROUP BY m.creatorUser ORDER BY COUNT(m) DESC")
	List<User> findBestWritterUsers();
	
}
