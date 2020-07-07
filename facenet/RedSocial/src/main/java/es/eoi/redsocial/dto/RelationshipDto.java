package es.eoi.redsocial.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class RelationshipDto {

	private Integer id;

	private Boolean amigos;
	
	private UserDto seguidor;
	
	private UserDto seguido;

}
