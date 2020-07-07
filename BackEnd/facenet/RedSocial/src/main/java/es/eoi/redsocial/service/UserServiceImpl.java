package es.eoi.redsocial.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import es.eoi.redsocial.entity.Relationship;
import es.eoi.redsocial.entity.User;
import es.eoi.redsocial.repository.UserRepository;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	UserRepository userRepo;
	
	public List<User> getAllUsers() {
		return userRepo.findAll();
	}

	public User findUserById(Integer id) {
		return userRepo.findById(id).orElse(null);
	}

	public void createUser(User user) {
		userRepo.save(user);
	}

	public User findByUserAndPass(String user, String pass) {
		return userRepo.findByUserAndPass(user, pass);
	}

	public User findFriendById(User user, Integer id) {
		User friend = null;
		List<Relationship> myFriends = user.getFollowing();
	
		for (Relationship relationship : myFriends) {
			if (relationship.getSeguido().getId().equals(id)) {
				friend = relationship.getSeguido();
			}
		}
		
		return friend;
	}

	public List<User> findBestScoredUsers() {
		List<User> allUsers = userRepo.findBestScoredUsers();
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
