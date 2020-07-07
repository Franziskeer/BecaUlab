package es.eoi.redsocial.controller;

import java.util.ArrayList;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import es.eoi.redsocial.dto.EventDto;
import es.eoi.redsocial.dto.FullEventDto;
import es.eoi.redsocial.dto.UserDto;
import es.eoi.redsocial.entity.Assistance;
import es.eoi.redsocial.entity.Event;
import es.eoi.redsocial.entity.User;
import es.eoi.redsocial.service.AssistanceService;
import es.eoi.redsocial.service.EventService;
import es.eoi.redsocial.service.UserService;

@RestController
public class EventController {

	public static Integer SCORE_EVENTS = 10;
	public static Integer SCORE_10_EVENTS = 100;
	public static Integer SCORE_ASSIST_EVENT = 1;
	public static Integer SCORE_100_EVENTS_ASSIST = 5;
	
	@Autowired
	EventService eventService;

	@Autowired
	AssistanceService assistanceService;
	
	@Autowired
	UserService userService;
	
	@GetMapping("/events")
	public ResponseEntity<List<FullEventDto>> getAllEvents() {
		ModelMapper modelMapper = new ModelMapper();
		List<Event> events = eventService.getAllEvents();
		List<FullEventDto> eventsDto = new ArrayList<>();

		for (Event event : events) {
			eventsDto.add(modelMapper.map(event, FullEventDto.class));
		}

		return new ResponseEntity<>(eventsDto, HttpStatus.OK);
	}

	@GetMapping("/events/{id}")
	public ResponseEntity<FullEventDto> findEventById(@PathVariable Integer id) {
		ModelMapper modelMapper = new ModelMapper();
		Event event = eventService.getEventsbyId(id);
		FullEventDto eventDto = modelMapper.map(event, FullEventDto.class);

		return new ResponseEntity<>(eventDto, HttpStatus.OK);
	}

	@PostMapping("/events")
	public void createEvent(@RequestBody EventDto newEvent) {
		ModelMapper modelMapper = new ModelMapper();
		Event event = eventService.getEventsbyId(newEvent.getId());
		
		if (event == null) {
			event = modelMapper.map(newEvent, Event.class);
			
			event.setCreatorUser(userService.findUserById(newEvent.getCreator()));
			
			User user = event.getCreatorUser();
			
			if (user.getCreatedEvents().size() < 10) {
				user.setScore(user.getScore() + SCORE_EVENTS);
			} else {
				user.setScore(user.getScore() + SCORE_10_EVENTS);
			}
			
			eventService.createEvent(event);
		}
	}

	@PostMapping("/events/{id}/yesAssitance")
	public void assistToEvent(@PathVariable Integer id, @RequestParam Integer userId) {
		User user = userService.findUserById(userId);
		Event event = eventService.getEventsbyId(id);
		Assistance assistance = assistanceService.findByUserAndEvent(user, event);
		Boolean assist = true;
		
		if (assistance != null) {
			assist = assistance.getAssist();
		}

		if (user != null && event != null) {
			assistanceService.assistEvent(event, user, true);
			
			if (!assist) {
				user.setScore(user.getScore() + SCORE_ASSIST_EVENT);
				
				User userCreator = event.getCreatorUser();
				
				if (userCreator.getCreatedEvents().size() < 100) {
					userCreator.setScore(userCreator.getScore() + SCORE_ASSIST_EVENT);
				} else {
					userCreator.setScore(userCreator.getScore() + SCORE_100_EVENTS_ASSIST);
				}
				
				userService.createUser(user);
				userService.createUser(userCreator);
			}
		}
	}
	
	@PostMapping("/events/{id}/notAssistance")
	public void notAssistToEvent(@PathVariable Integer id, @RequestParam Integer userId) {
		User user = userService.findUserById(userId);
		Event event = eventService.getEventsbyId(id);
		Assistance assistance = assistanceService.findByUserAndEvent(user, event);
		Boolean assist = false;
		
		if (assistance != null) {
			assist = assistance.getAssist();
		}
		
		if (user != null && event != null) {
			assistanceService.assistEvent(event, user, false);
			
			if (assist) {
				user.setScore(user.getScore() - SCORE_ASSIST_EVENT);
			
				User userCreator = event.getCreatorUser();
				
				if (userCreator.getCreatedEvents().size() < 100) {
					userCreator.setScore(userCreator.getScore() - SCORE_ASSIST_EVENT);
				} else {
					userCreator.setScore(userCreator.getScore() - SCORE_100_EVENTS_ASSIST);
				}
				
				userService.createUser(user);
				userService.createUser(userCreator);
			}
		}
	}

	@GetMapping("/events/{id}/users/yesAssistance")
	public ResponseEntity<List<UserDto>> getUsersYesAssistance(@PathVariable Integer id) {
		ModelMapper modelMapper = new ModelMapper();
		Event event = eventService.getEventsbyId(id);
		List<UserDto> usersDto = new ArrayList<>();
		List<Assistance> assistances = event.getAssistances();
		
		for (Assistance assistance : assistances) {
			if (assistance.getAssist()) {
				usersDto.add(modelMapper.map(assistance.getUser(), UserDto.class));
			}
		}
		
		return new ResponseEntity<>(usersDto, HttpStatus.OK);
	}
	
	@GetMapping("/events/{id}/users/notAssistance")
	public ResponseEntity<List<UserDto>> getUsersNotAssistance(@PathVariable Integer id) {
		ModelMapper modelMapper = new ModelMapper();
		Event event = eventService.getEventsbyId(id);
		List<UserDto> usersDto = new ArrayList<>();
		List<Assistance> assistances = event.getAssistances();
		
		for (Assistance assistance : assistances) {
			if (!assistance.getAssist()) {
				usersDto.add(modelMapper.map(assistance.getUser(), UserDto.class));
			}
		}
		
		return new ResponseEntity<>(usersDto, HttpStatus.OK);
	}
	

	@GetMapping("/events/user/{id}/yesAssistance")
	public ResponseEntity<List<FullEventDto>> getEventsYesAssistance(@PathVariable Integer id) {
		ModelMapper modelMapper = new ModelMapper();
		User user = userService.findUserById(id);
		List<FullEventDto> eventsDto = new ArrayList<>();
		List<Assistance> assistances = user.getAssistances();
		
		for (Assistance assistance : assistances) {
			if (assistance.getAssist()) {
				eventsDto.add(modelMapper.map(assistance.getEvent(), FullEventDto.class));
			}
		}
		
		return new ResponseEntity<>(eventsDto, HttpStatus.OK);
	}
	
	@GetMapping("/events/user/{id}/notAssistance")
	public ResponseEntity<List<FullEventDto>> getEventsNotAssistance(@PathVariable Integer id) {
		ModelMapper modelMapper = new ModelMapper();
		User user = userService.findUserById(id);
		List<FullEventDto> eventsDto = new ArrayList<>();
		List<Assistance> assistances = user.getAssistances();
		
		for (Assistance assistance : assistances) {
			if (!assistance.getAssist()) {
				eventsDto.add(modelMapper.map(assistance.getEvent(), FullEventDto.class));
			}
		}
		
		return new ResponseEntity<>(eventsDto, HttpStatus.OK);
	}
	
	@PutMapping("/events/refreshEventState")
	public void refreshEventState() {
		List<Event> eventos = eventService.findAll();
		
		for (Event event : eventos) {
			eventService.refreshState(event);
		}
	}
}













