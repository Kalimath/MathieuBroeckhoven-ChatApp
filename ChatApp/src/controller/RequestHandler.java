package controller;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import domain.*;

import java.io.IOException;

public abstract class RequestHandler {

	private PersonService personService;
	private MessageService messageService;

	public abstract void handleRequest (HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException;

	public void setModel (PersonService personService) {
		this.personService = personService;
	}

	public PersonService getPersonService() {
		return personService;
	}

	protected boolean isFromUserWithRole (HttpServletRequest request, Role role) {
		Person person = (Person) request.getSession().getAttribute("user");
		if (person != null && person.getRole().equals(role)) {
			return true;
		}
		return false;
	}

    public void setMessageService(MessageService messageService) {
		this.messageService = messageService;
    }

	public MessageService getMessageService() {
		return messageService;
	}
}
