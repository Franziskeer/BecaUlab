package es.eoi.redsocial.service;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import es.eoi.redsocial.entity.Event;
import es.eoi.redsocial.entity.User;
import es.eoi.redsocial.enums.States;
import es.eoi.redsocial.repository.EventRepository;

@Service
public class EventServiceImpl implements EventService {

	@Autowired
	EventRepository eventRepository;

	public List<Event> getAllEvents() {
		return this.eventRepository.findAll();
	}

	public Event getEventsbyId(Integer id) {
		return this.eventRepository.findById(id).orElse(null);
	}

	public void createEvent(Event event) {
		if (event.getCreatorUser() != null) {
			refreshState(event);
		}
	}

	public List<Event> findPassedEvents() {
		Calendar calendar = Calendar.getInstance();

		calendar.set(calendar.get(Calendar.YEAR), calendar.get(Calendar.MONTH), calendar.get(Calendar.DAY_OF_MONTH), 
				23, 59, 59);
		Date currentTime = calendar.getTime();
		
		return eventRepository.findByEventDateGreaterThan(currentTime);
	}

	public List<Event> findCurrentEvents() {
		Calendar calendar = Calendar.getInstance();

		calendar.set(calendar.get(Calendar.YEAR), calendar.get(Calendar.MONTH), calendar.get(Calendar.DAY_OF_MONTH), 
				0, 0, 0);
		Date fechaInicio = calendar.getTime();

		calendar.set(calendar.get(Calendar.YEAR), calendar.get(Calendar.MONTH), calendar.get(Calendar.DAY_OF_MONTH), 
				23, 59, 59);
		Date fechaFinal = calendar.getTime();

		return eventRepository.findByEventDateBetween(fechaInicio, fechaFinal);
	}

	public List<User> findBestActiveUsers() {
		List<User> bestUsers = new ArrayList<>();
		Integer count = 0;
		
		for (User user : eventRepository.findBestActiveUsers()) {
			if (count != 3) {
				bestUsers.add(user);
				count++;
			}
		}
		
		return bestUsers;
	}
	
	public void refreshState(Event event) {
		Calendar calendar = Calendar.getInstance();

		calendar.set(calendar.get(Calendar.YEAR), calendar.get(Calendar.MONTH), calendar.get(Calendar.DAY_OF_MONTH), 0, 0, 0);
		Date fechaInicio = calendar.getTime();

		calendar.set(calendar.get(Calendar.YEAR), calendar.get(Calendar.MONTH), calendar.get(Calendar.DAY_OF_MONTH), 23, 59, 59);
		Date fechaFinal = calendar.getTime();
		
		if (event.getEventDate().before(fechaInicio)) {
			event.setState(States.SCHEDULED.toString());
		} else if (event.getEventDate().after(fechaFinal)) {
			event.setState(States.PASSED.toString());
		} else {
			event.setState(States.IN_PROGRESS.toString());
		}
			
		eventRepository.save(event);
	}

	public List<Event> findAll() {
		return eventRepository.findAll();
	}

}
