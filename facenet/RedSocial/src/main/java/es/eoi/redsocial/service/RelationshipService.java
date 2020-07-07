package es.eoi.redsocial.service;

import java.util.List;

import es.eoi.redsocial.entity.Relationship;
import es.eoi.redsocial.entity.User;

public interface RelationshipService {

	void createRelationship(User me, User myFriend, Boolean friends);

	Relationship findRelationById(Integer id);

	void deleteRelationship(Integer id);

	Boolean areFriends(User user, User myFriend);

	List<User> findBestFriendlyUsers();

}
