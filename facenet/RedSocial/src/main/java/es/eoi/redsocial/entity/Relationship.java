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
@Entity(name = "RELATIONSHIP")
public class Relationship {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "SEGUIDOR", referencedColumnName = "ID")
	private User seguidor;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "SEGUIDO", referencedColumnName = "ID")
	private User seguido;

	@Column(name = "AMIGOS")
	private Boolean amigos;

}
