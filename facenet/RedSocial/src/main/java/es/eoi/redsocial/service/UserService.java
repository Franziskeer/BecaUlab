package es.eoi.redsocial.service;

import java.util.List;

import es.eoi.redsocial.entity.User;

public interface UserService {
	
	public List<User> getAllUsers();

	public User findUserById(Integer id);

	public void createUser(User user);

	public User findByUserAndPass(String user, String pass);

	public User findFriendById(User user, Integer id);

	public List<User> findBestScoredUsers();
	
}
