package es.eoi.redsocial.dto;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class FullMessageDto {

	private Integer id;

	private String content;

	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy")
	private Date publishDate;

	private UserDto creatorUser;
}
