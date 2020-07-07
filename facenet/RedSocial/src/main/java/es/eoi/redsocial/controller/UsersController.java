package es.eoi.redsocial.controller;

import java.util.ArrayList;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import es.eoi.redsocial.dto.FullUserDto;
import es.eoi.redsocial.dto.RelationshipDto;
import es.eoi.redsocial.dto.UserDto;
import es.eoi.redsocial.entity.Relationship;
import es.eoi.redsocial.entity.User;
import es.eoi.redsocial.service.RelationshipService;
import es.eoi.redsocial.service.UserService;

@RestController
public class UsersController {

	@Autowired
	UserService userService;
	
	@Autowired
	RelationshipService relationService;
	
	@GetMapping("/users")
	public ResponseEntity<List<UserDto>> getAllUsers() {
		ModelMapper modelMapper = new ModelMapper();
		List<User> users = userService.getAllUsers();
		List<UserDto> usersDto = new ArrayList<>();

		for (User user : users) {
			usersDto.add(modelMapper.map(user, UserDto.class));
		}

		return new ResponseEntity<>(usersDto, HttpStatus.OK);
	}

	@GetMapping("/users/{id}")
	public ResponseEntity<UserDto> findUserById(@PathVariable Integer id) {
		ModelMapper modelMapper = new ModelMapper();
		User user = userService.findUserById(id);
		UserDto userDto = modelMapper.map(user, UserDto.class);
		
		return new ResponseEntity<>(userDto, HttpStatus.OK);
	}

	@GetMapping("/users/fullUser/{id}")
	public ResponseEntity<FullUserDto> findFullUserById(@PathVariable Integer id) {
		ModelMapper modelMapper = new ModelMapper();
		User user = userService.findUserById(id);
		FullUserDto fullUserDto = modelMapper.map(user, FullUserDto.class);
		
		return new ResponseEntity<>(fullUserDto, HttpStatus.OK);
	}

	@PostMapping("/users")
	public void createUser(@RequestBody UserDto newUser) {
		ModelMapper modelMapper = new ModelMapper();
		User user = modelMapper.map(newUser, User.class);
		user.setScore(0);
		
		userService.createUser(user);
	}
	
	@PutMapping("/users/{id}")
	public void updateSurname(@PathVariable Integer id, @RequestParam String newSurname) {
		User user = userService.findUserById(id);
		user.setSurname(newSurname);
		userService.createUser(user);
	}
	
	@PostMapping("/users/login")
	public ResponseEntity<FullUserDto> login(@RequestParam String user, @RequestParam String pass) {
		ModelMapper modelMapper = new ModelMapper();
		User fullUser = userService.findByUserAndPass(user, pass);
		FullUserDto fullUserDto = new FullUserDto();
		
		if (fullUser != null) {
			fullUserDto = modelMapper.map(fullUser, FullUserDto.class);
			return new ResponseEntity<>(fullUserDto, HttpStatus.OK);
		}
		
		return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	}
	
	@GetMapping("/users/{id}/friendsRelationship")
	public ResponseEntity<List<RelationshipDto>> getAcceptedFriends(@PathVariable Integer id) {
		ModelMapper modelMapper = new ModelMapper();
		User user = userService.findUserById(id);
		List<Relationship> relations = user.getFollowing();
		List<RelationshipDto> relationsDto = new ArrayList<>();
		
		for (Relationship relation : relations) {
			if (relation.getAmigos()) {
				relationsDto.add(modelMapper.map(relation, RelationshipDto.class));
			}
		}
		
		return new ResponseEntity<>(relationsDto, HttpStatus.OK);
	}
	
	@GetMapping("/users/{id}/pendingRelationship")
	public ResponseEntity<List<RelationshipDto>> getPendentFriends(@PathVariable Integer id) {
		ModelMapper modelMapper = new ModelMapper();
		User user = userService.findUserById(id);
		List<Relationship> relations = user.getFollowing();
		List<RelationshipDto> relationsDto = new ArrayList<>();
		
		for (Relationship relation : relations) {
			if (!relation.getAmigos()) {
				relationsDto.add(modelMapper.map(relation, RelationshipDto.class));
			}
		}
		
		return new ResponseEntity<>(relationsDto, HttpStatus.OK);
	}
	
	@PostMapping("/users/{id}/inviteFriend")
	public void createRelationship(@PathVariable Integer id, @RequestParam Integer friendId) {
		User me = userService.findUserById(id);
		User myFriend = userService.findUserById(friendId);
		
		relationService.createRelationship(me, myFriend, false);
	}
	
	@PutMapping("/users/relationship/{id}")
	public void acceptRelationship(@PathVariable Integer id) {
		Relationship modifyRelation = relationService.findRelationById(id);
		User me = modifyRelation.getSeguidor();
		User myFriend = modifyRelation.getSeguido();

		relationService.createRelationship(me, myFriend, true);
	}
	
	@DeleteMapping("/users/relationship/{id}")
	public void deleteRelationship(@PathVariable Integer id) {
		relationService.deleteRelationship(id);
	}
	
}
