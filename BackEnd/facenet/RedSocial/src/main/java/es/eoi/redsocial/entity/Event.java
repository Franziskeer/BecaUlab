package es.eoi.redsocial.entity;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity(name = "EVENT")
public class Event {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@Column(name = "NAME")
	private String name;

	@Column(name = "DESCRIPTION")
	private String description;

	@Column(name = "EVENT_DATE")
	private Date eventDate;

	// Asistencias a este evento
	@OneToMany(mappedBy = "event", fetch = FetchType.LAZY)
	private List<Assistance> assistances;

	// Creador de este evento
	@ManyToOne(fetch = FetchType.LAZY)
	private User creatorUser;
	
	@Column(name = "STATE")
	private String state;
	
}
