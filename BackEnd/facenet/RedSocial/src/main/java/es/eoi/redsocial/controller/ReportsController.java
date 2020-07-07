package es.eoi.redsocial.controller;

import java.util.ArrayList;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import es.eoi.redsocial.dto.FullEventDto;
import es.eoi.redsocial.dto.UserDto;
import es.eoi.redsocial.entity.Event;
import es.eoi.redsocial.entity.User;
import es.eoi.redsocial.service.AssistanceService;
import es.eoi.redsocial.service.EventService;
import es.eoi.redsocial.service.MessageService;
import es.eoi.redsocial.service.RelationshipService;
import es.eoi.redsocial.service.UserService;

@RestController
public class ReportsController {

	@Autowired
	AssistanceService assistanceService;
	
	@Autowired
	EventService eventService;
	
	@Autowired
	MessageService messageService;
	
	@Autowired
	RelationshipService relationService;
	
	@Autowired
	UserService userService;
	
	@GetMapping("/reports/bestEvents")
	public ResponseEntity<List<FullEventDto>> getBestAssistanceEvents() {
		ModelMapper modelMapper = new ModelMapper();
		List<FullEventDto> bestEvents = new ArrayList<>();
		List<Event> events = assistanceService.findTop3BestEvents();
		
		for (Event event : events) {
			bestEvents.add(modelMapper.map(event, FullEventDto.class));
		}
		
		return new ResponseEntity<>(bestEvents, HttpStatus.OK);
	}
	
	@GetMapping("/reports/worstEvents")
	public ResponseEntity<List<FullEventDto>> getWorstAssistanceEvents() {
		ModelMapper modelMapper = new ModelMapper();
		List<FullEventDto> bestEvents = new ArrayList<>();
		List<Event> events = assistanceService.findTop3WorstEvents();
		
		for (Event event : events) {
			bestEvents.add(modelMapper.map(event, FullEventDto.class));
		}
		
		return new ResponseEntity<>(bestEvents, HttpStatus.OK);
	}
	
	@GetMapping("/reports/passedEvents")
	public ResponseEntity<List<FullEventDto>> getPassedEvents() {
		ModelMapper modelMapper = new ModelMapper();
		List<FullEventDto> passedEvents = new ArrayList<>();
		List<Event> events = eventService.findPassedEvents();
		
		for (Event event : events) {
			passedEvents.add(modelMapper.map(event, FullEventDto.class));
		}
		
		return new ResponseEntity<>(passedEvents, HttpStatus.OK);
	}
	
	@GetMapping("/reports/inProgressEvents")
	public ResponseEntity<List<FullEventDto>> getInProgressEvents() {
		ModelMapper modelMapper = new ModelMapper();
		List<FullEventDto> passedEvents = new ArrayList<>();
		List<Event> events = eventService.findCurrentEvents();
		
		for (Event event : events) {
			passedEvents.add(modelMapper.map(event, FullEventDto.class));
		}
		
		return new ResponseEntity<>(passedEvents, HttpStatus.OK);
	}
	
	@GetMapping("/reports/bestActiveUsers")
	public ResponseEntity<List<UserDto>> getBestActiveUsers() {
		ModelMapper modelMapper = new ModelMapper();
		List<UserDto> bestUsers = new ArrayList<>();
		List<User> users = eventService.findBestActiveUsers();
		
		for (User user : users) {
			bestUsers.add(modelMapper.map(user, UserDto.class));
		}
		
		return new ResponseEntity<>(bestUsers, HttpStatus.OK);
	}
	
	@GetMapping("/reports/bestWritterUsers")
	public ResponseEntity<List<UserDto>> getBestWritterUsers() {
		ModelMapper modelMapper = new ModelMapper();
		List<UserDto> bestUsers = new ArrayList<>();
		List<User> users = messageService.findBestWritterUsers();
		
		for (User user : users) {
			bestUsers.add(modelMapper.map(user, UserDto.class));
		}
		
		return new ResponseEntity<>(bestUsers, HttpStatus.OK);
	}
	
	@GetMapping("/reports/bestFriendlyUsers")
	public ResponseEntity<List<UserDto>> getBestFriendlyUsers() {
		ModelMapper modelMapper = new ModelMapper();
		List<UserDto> bestUsers = new ArrayList<>();
		List<User> users = relationService.findBestFriendlyUsers();
		
		for (User user : users) {
			bestUsers.add(modelMapper.map(user, UserDto.class));
		}
		
		return new ResponseEntity<>(bestUsers, HttpStatus.OK);
	}
	
	@GetMapping("/reports/bestAssistanceUsers")
	public ResponseEntity<List<UserDto>> getBestAssistanceUsers() {
		ModelMapper modelMapper = new ModelMapper();
		List<UserDto> bestUsers = new ArrayList<>();
		List<User> users = assistanceService.findBestAssistanceUsers();
		
		for (User user : users) {
			bestUsers.add(modelMapper.map(user, UserDto.class));
		}
		
		return new ResponseEntity<>(bestUsers, HttpStatus.OK);
	}
	
	@GetMapping("/reports/bestScoredUsers")
	public ResponseEntity<List<UserDto>> getBestScoredUsers() {
		ModelMapper modelMapper = new ModelMapper();
		List<UserDto> bestUsers = new ArrayList<>();
		List<User> users = userService.findBestScoredUsers();
		
		for (User user : users) {
			bestUsers.add(modelMapper.map(user, UserDto.class));
		}
		
		return new ResponseEntity<>(bestUsers, HttpStatus.OK);
	}
	
}
