package es.eoi.redsocial.dto;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

import es.eoi.redsocial.enums.States;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class FullEventDto {
	private Integer id;
	
	private String name;

	private String description;

	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy")
	private Date date;

	private UserDto creator;
	
	private States state;
}
