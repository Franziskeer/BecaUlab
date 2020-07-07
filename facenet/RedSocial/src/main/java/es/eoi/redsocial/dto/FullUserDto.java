package es.eoi.redsocial.dto;

import java.util.Date;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class FullUserDto {

	private Integer id;

	private String name;

	private String surname;

	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy")
	private Date birthDate;

	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy")
	private Date startDate;

	private String user;

	private String pass;
	
	private List<ReactionDto> reactions;

	private List<AssistanceDto> assistances;

	private List<FullMessageDto> createdMessages;

	private List<FullEventDto> createdEvents;

	private List<RelationshipDto> following;

	private List<RelationshipDto> followers;

	private Integer score;
}
