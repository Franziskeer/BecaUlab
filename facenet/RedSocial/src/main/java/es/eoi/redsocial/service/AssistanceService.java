package es.eoi.redsocial.service;

import java.util.List;

import es.eoi.redsocial.entity.Assistance;
import es.eoi.redsocial.entity.Event;
import es.eoi.redsocial.entity.User;

public interface AssistanceService {

	void assistEvent(Event event, User user, Boolean willAssist);

	List<Event> findTop3BestEvents();

	List<Event> findTop3WorstEvents();

	List<User> findBestAssistanceUsers();

	Assistance findByUserAndEvent(User user, Event event);
	
}
