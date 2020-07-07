package es.eoi.redsocial.task;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import es.eoi.redsocial.entity.Event;
import es.eoi.redsocial.service.EventService;

@Component
public class RefreshEventStateTask {

	@Autowired
	EventService eventService;
	
	@Scheduled(fixedRate = 3600000)
	public void refreshEventStateEachHour() {
		List<Event> eventos = eventService.findAll();
		
		for (Event event : eventos) {
			eventService.refreshState(event);
		}
	}
	
}
