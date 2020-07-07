package es.eoi.redsocial.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import es.eoi.redsocial.entity.Message;
import es.eoi.redsocial.entity.Reaction;
import es.eoi.redsocial.entity.User;
import es.eoi.redsocial.repository.ReactionRepository;

@Service
public class ReactionServiceImpl implements ReactionService {

	@Autowired
	ReactionRepository reactionRepository; 
	
	public void createReaction(Message message, String reactionType, User user) {
		Reaction reaction = reactionRepository.findByUserAndMessage(user, message);
		
		if (reaction != null) {
			if (!reactionType.equals(reaction.getReactionType())) {
				reaction.setReactionType(reactionType);
			}
		} else {
			reaction = new Reaction();
			reaction.setMessage(message);
			reaction.setReactionType(reactionType);
			reaction.setUser(user);
			
		}
		
		reactionRepository.save(reaction);
	}

}
