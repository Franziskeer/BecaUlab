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
@Entity(name = "MESSAGE")
public class Message {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@Column(name = "CONTENT")
	private String content;
	
	@Column(name = "PUBLISH_DATE")
	private Date publishDate;
	
	// Reacciones a este mensaje
	@OneToMany(mappedBy = "message", fetch = FetchType.LAZY)
	private List<Reaction> reactions;
	
	// Creador de este mensaje
	@ManyToOne(fetch = FetchType.LAZY)
	private User creatorUser;
	
}
