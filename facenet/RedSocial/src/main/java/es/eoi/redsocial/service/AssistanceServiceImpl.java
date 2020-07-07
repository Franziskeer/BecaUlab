package es.eoi.redsocial.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import es.eoi.redsocial.entity.Assistance;
import es.eoi.redsocial.entity.Event;
import es.eoi.redsocial.entity.User;
import es.eoi.redsocial.repository.AssistanceRepository;

@Service
public class AssistanceServiceImpl implements AssistanceService {

	@Autowired
	AssistanceRepository assistanceRepository;

	public void assistEvent(Event event, User user, Boolean willAssist) {
		Assistance assistance = findByUserAndEvent(user, event);
		
		if (assistance != null) {
			if (!willAssist.equals(assistance.getAssist())) {
				assistance.setAssist(willAssist);
			}
		} else {
			assistance = new Assistance();
			assistance.setEvent(event);
			assistance.setUser(user);
			assistance.setAssist(willAssist);
		}

		assistanceRepository.save(assistance);
	}

	public List<Event> findTop3BestEvents() {
		List<Event> allEvents = assistanceRepository.findBestEvents();
		List<Event> bestEvents = new ArrayList<>();
		Integer count = 0;
		
		for (Event event : allEvents) {
			if (count != 3) {
				bestEvents.add(event);
				count++;
			}
		}
		
		return bestEvents;
	}
	
	public List<Event> findTop3WorstEvents() {
		List<Event> allEvents = assistanceRepository.findWorstEvents();
		List<Event> bestEvents = new ArrayList<>();
		Integer count = 0;
		
		for (Event event : allEvents) {
			if (count != 3) {
				bestEvents.add(event);
				count++;
			}
		}
		
		return bestEvents;
	}

	public List<User> findBestAssistanceUsers() {
		List<User> allUsers = assistanceRepository.findBestAssistanceUsers();
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

	public Assistance findByUserAndEvent(User user, Event event) {
		return this.assistanceRepository.findByUserAndEvent(user, event);
	}
}
