package it.furmax.template.repository;

import org.jboss.logging.Logger;

import it.furmax.template.model.CfgSystemMessage;

public class MessageRepository extends AbstractRepository<CfgSystemMessage> {

	private static Logger log = Logger.getLogger(MessageRepository.class.getName());

	public MessageRepository() {
		type = CfgSystemMessage.class;
	}

}
