package es.eoi.redsocial.entity;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity(name = "USER")
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@Column(name = "NAME")
	private String name;

	@Column(name = "SURNAME")
	private String surname;

	@Column(name = "BIRTH_DATE")
	private Date birthDate;
	
	@Column(name = "START_DATE")
	private Date startDate;

	@Column(name = "USER", unique = true)
	private String user;

	@Column(name = "PASS")
	private String pass;

	// Reacciones que ha hecho este usuario
	@OneToMany(mappedBy = "user", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private List<Reaction> reactions;

	// Ebhentos a los que ha asistido este usuario
	@OneToMany(mappedBy = "user", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private List<Assistance> assistances;

	// Mensajes creados por este usuario
	@OneToMany(mappedBy = "creatorUser", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private List<Message> createdMessages;

	// Eventos creados por este usuario
	@OneToMany(mappedBy = "creatorUser", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private List<Event> createdEvents;

	// Amistades enviadas
	@OneToMany(mappedBy = "seguidor", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private List<Relationship> following;

	// Amistades recibidas
	@OneToMany(mappedBy = "seguido", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private List<Relationship> followers;
	
	private Integer score;

}
