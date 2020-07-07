package es.eoi.redsocial.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity(name = "REACTION")
public class Reaction {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn
    private Message message;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn
	private User user;
	
	@Column(name = "REACTION_TYPE")
	private String reactionType;
	
}
