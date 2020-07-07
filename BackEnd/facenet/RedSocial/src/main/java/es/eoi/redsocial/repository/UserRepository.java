package es.eoi.redsocial.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import es.eoi.redsocial.entity.User;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {

	public User findByUserAndPass(String user, String pass);

	// SELECT * FROM USER u GROUP BY a.SCORE DESC
	@Query("SELECT u FROM USER u ORDER BY u.score DESC")
	public List<User> findBestScoredUsers();
	
}
