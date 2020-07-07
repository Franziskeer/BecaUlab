package es.eoi.redsocial.service;

import java.util.List;

import es.eoi.redsocial.entity.Event;
import es.eoi.redsocial.entity.User;

public interface EventService {

	public List<Event> getAllEvents();

	public Event getEventsbyId(Integer id);

	public void createEvent(Event myEvent);

	public List<Event> findPassedEvents();

	public List<Event> findCurrentEvents();

	public List<User> findBestActiveUsers();

	public void refreshState(Event event);

	public List<Event> findAll();
}
