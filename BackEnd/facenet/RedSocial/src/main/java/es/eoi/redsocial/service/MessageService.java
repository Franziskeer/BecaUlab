package es.eoi.redsocial.service;

import java.util.List;

import es.eoi.redsocial.entity.Message;
import es.eoi.redsocial.entity.User;

public interface MessageService {

	public Message getMessagebyId(Integer id);

	public void createMessage(Message myMessage);

	public void deleteMessage(Integer id);
	
	public List<User> findBestWritterUsers();
}
