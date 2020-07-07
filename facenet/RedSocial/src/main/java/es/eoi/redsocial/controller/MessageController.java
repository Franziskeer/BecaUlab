package es.eoi.redsocial.controller;

import java.util.ArrayList;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import es.eoi.redsocial.dto.FullMessageDto;
import es.eoi.redsocial.dto.FullReactionDto;
import es.eoi.redsocial.dto.MessageDto;
import es.eoi.redsocial.entity.Message;
import es.eoi.redsocial.entity.Reaction;
import es.eoi.redsocial.entity.User;
import es.eoi.redsocial.enums.ReactionType;
import es.eoi.redsocial.service.MessageService;
import es.eoi.redsocial.service.ReactionService;
import es.eoi.redsocial.service.RelationshipService;
import es.eoi.redsocial.service.UserService;

@RestController
public class MessageController {

	@Autowired
	MessageService messageService;

	@Autowired
	UserService userService;
	
	@Autowired
	ReactionService reactionService;
	
	@Autowired
	RelationshipService relationService;
	
	@GetMapping("/message/{id}")
	public ResponseEntity<FullMessageDto> findMessageById(@PathVariable Integer id) {
		ModelMapper modelMapper = new ModelMapper();
		Message message = messageService.getMessagebyId(id);
		FullMessageDto messageDto = modelMapper.map(message, FullMessageDto.class);

		return new ResponseEntity<>(messageDto, HttpStatus.OK);
	}

	@GetMapping("/messages/user/{id}")
	public ResponseEntity<List<FullMessageDto>> findAllMessagesOfUser(@PathVariable Integer id) {
		ModelMapper modelMapper = new ModelMapper();
		User user = userService.findUserById(id);
		List<Message> messages = user.getCreatedMessages();
		List<FullMessageDto> messagesDto = new ArrayList<>();
		
		for (Message message : messages) {
			messagesDto.add(modelMapper.map(message, FullMessageDto.class));
		}
		
		return new ResponseEntity<>(messagesDto, HttpStatus.OK);
	}
	
	@GetMapping("/messages/user/{id}/friendPost")
	public ResponseEntity<List<FullMessageDto>> findAllMessagesOfFriend(@PathVariable Integer id, @RequestParam Integer friendId) {
		ModelMapper modelMapper = new ModelMapper();
		User user = userService.findUserById(id);
		User myFriend = userService.findFriendById(user, friendId);
		List<FullMessageDto> messagesDto = new ArrayList<>();
		List<Message> messages = myFriend.getCreatedMessages();
		
		if (relationService.areFriends(user, myFriend)) {	
			for (Message message : messages) {
				messagesDto.add(modelMapper.map(message, FullMessageDto.class));
			}
			
			return new ResponseEntity<>(messagesDto, HttpStatus.OK);
		} 
		
		return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	}
	
	@PostMapping("/messages")
	public void createMessage(@RequestBody MessageDto newMessage) {
		ModelMapper modelMapper = new ModelMapper();
		Message message = modelMapper.map(newMessage, Message.class);
		User user = userService.findUserById(newMessage.getCreator());
		message.setCreatorUser(user);
		messageService.createMessage(message);
	}
	
	@GetMapping("/messages/{id}/reactions")
	public ResponseEntity<List<FullReactionDto>> findReactions(@PathVariable Integer id) {
		ModelMapper modelMapper = new ModelMapper();
		Message message = messageService.getMessagebyId(id);
	
		List<Reaction> reactions = message.getReactions();
		List<FullReactionDto> reactionsDto = new ArrayList<>();
		
		for (Reaction reaction : reactions) {
			reactionsDto.add(modelMapper.map(reaction, FullReactionDto.class));
		}
		
		return new ResponseEntity<>(reactionsDto, HttpStatus.OK);
	}
	
	@DeleteMapping("/messages/{id}")
	public void deleteMessage(@PathVariable Integer id) {
		messageService.deleteMessage(id);
	}
	
	@PostMapping("/messages/{id}/reactions")
	public void createReaction(@PathVariable Integer id, @RequestParam Integer userId, @RequestParam ReactionType reactionType) {
		Message message = messageService.getMessagebyId(id);
		String reaction = reactionType.toString();
		User user = userService.findUserById(userId);
		
		reactionService.createReaction(message, reaction, user);
	}
	
}
