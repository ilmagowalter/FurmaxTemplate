package it.furmax.template.controller;

import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;

import org.jboss.logging.Logger;

import it.furmax.template.model.CfgSystemMessage;
import it.furmax.template.model.CfgSystemMessage_;
import it.furmax.template.repository.MessageRepository;

@Stateless
public class MessageController {

	private static Logger log = Logger.getLogger(MessageController.class.getName());

	@Inject
	private MessageRepository messageRepository;

	public String getMessage(final String code) {
		List<CfgSystemMessage> res = messageRepository.find(CfgSystemMessage_.code, code);
		if (res == null || res.isEmpty()) {
			log.warn("listWithCode - no system message for code " + code);
			return null;
		}
		// message are unique by code
		return res.get(0).getMessage();
	}

}
