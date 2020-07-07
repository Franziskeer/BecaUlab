package es.eoi.redsocial.service;

import es.eoi.redsocial.entity.Message;
import es.eoi.redsocial.entity.User;

public interface ReactionService {

	void createReaction(Message message, String reactionType, User user);

}
