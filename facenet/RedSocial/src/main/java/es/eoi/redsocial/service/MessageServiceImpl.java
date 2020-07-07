package es.eoi.redsocial.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import es.eoi.redsocial.entity.Message;
import es.eoi.redsocial.entity.User;
import es.eoi.redsocial.repository.MessageRepository;

@Service
public class MessageServiceImpl implements MessageService {

	@Autowired
	MessageRepository repository;

	public Message getMessagebyId(Integer id) {
		return this.repository.findById(id).orElse(null);
	}

	public void createMessage(Message myMessage) {
		if (myMessage.getCreatorUser() != null) {
			this.repository.save(myMessage);
		}
	}

	public void deleteMessage(Integer id) {
		this.repository.deleteById(id);
	}

	public List<User> findBestWritterUsers() {
		List<User> allUsers = repository.findBestWritterUsers();
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
