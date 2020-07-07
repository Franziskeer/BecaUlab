package es.eoi.redsocial.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class FullReactionDto {

	private Integer id;
	
	private String reactionType;
	
	private UserDto user;
	
	private FullMessageDto message;
	
}
