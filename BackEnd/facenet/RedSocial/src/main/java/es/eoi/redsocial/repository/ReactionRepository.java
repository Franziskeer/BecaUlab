package es.eoi.redsocial.repository;

import org.springframework.data.jpa.repository.support.JpaRepositoryImplementation;
import org.springframework.stereotype.Repository;

import es.eoi.redsocial.entity.Message;
import es.eoi.redsocial.entity.Reaction;
import es.eoi.redsocial.entity.User;

@Repository
public interface ReactionRepository extends JpaRepositoryImplementation<Reaction, Integer>{

	Reaction findByUserAndMessage(User user, Message message);
	
}
