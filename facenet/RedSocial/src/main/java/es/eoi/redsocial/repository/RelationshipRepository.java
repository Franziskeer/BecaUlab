package es.eoi.redsocial.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.support.JpaRepositoryImplementation;
import org.springframework.stereotype.Repository;

import es.eoi.redsocial.entity.Relationship;
import es.eoi.redsocial.entity.User;

@Repository
public interface RelationshipRepository extends JpaRepositoryImplementation<Relationship, Integer> {

	Relationship findBySeguidorAndSeguido(User me, User myFriend);

	// SELECT r.SEGUIDOR, COUNT(*) FROM RELATIONSHIP r WHERE r.AMIGOS = true GROUP BY r.SEGUIDOR ORDER BY COUNT(*) DESC
	@Query("SELECT r.seguidor, COUNT(r) FROM RELATIONSHIP r WHERE r.amigos = true GROUP BY r.seguidor ORDER BY COUNT(r) DESC")
	List<User> findBestFriendlyUsers();
	
}
