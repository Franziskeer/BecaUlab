package es.eoi.redsocial.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import es.eoi.redsocial.entity.Relationship;
import es.eoi.redsocial.entity.User;
import es.eoi.redsocial.repository.RelationshipRepository;

@Service
public class RelationshipServiceImpl implements RelationshipService {

	@Autowired
	RelationshipRepository relationRepository;

	public void createRelationship(User me, User myFriend, Boolean friends) {
		Relationship relation = relationRepository.findBySeguidorAndSeguido(me, myFriend);
		
		if (!friends) {	
			if (relation == null && me != null && myFriend != null) {
				relation = new Relationship();
				relation.setSeguidor(me);
				relation.setSeguido(myFriend);
				relation.setAmigos(friends);
				relationRepository.save(relation);
			}
		} else {
			if (relation != null) {
				relation.setAmigos(friends);
				relationRepository.save(relation);
			}
		}
	}

	public Relationship findRelationById(Integer id) {
		return relationRepository.findById(id).orElse(null);
	}

	public void deleteRelationship(Integer id) {
		relationRepository.deleteById(id);
	}

	public Boolean areFriends(User user, User myFriend) {
		Relationship relation = relationRepository.findBySeguidorAndSeguido(user, myFriend);
		
		if (relation.getAmigos())
			return true;
		
		return false;
	}

	public List<User> findBestFriendlyUsers() {
		List<User> allUsers = relationRepository.findBestFriendlyUsers();
		List<User> bestUsers = new ArrayList<>();
		Integer count = 0;
		
		for (User user : allUsers) {
			if (count != 3) {
				bestUsers.add(user);
				count++;
			}
		}
		
		return bestUsers;
	}

}
