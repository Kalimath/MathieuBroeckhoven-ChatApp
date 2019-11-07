package controller;

import domain.MessageService;
import domain.PersonService;

public class ControllerFactory {
	
    public RequestHandler getController(String key, PersonService model, MessageService messageService) {
        return createHandler(key, model, messageService);
    }
    
	private RequestHandler createHandler(String handlerName, PersonService model, MessageService messageService) {
		RequestHandler handler = null;
		try {
			System.out.println(handlerName);
			Class<?> handlerClass = Class.forName("controller."+ handlerName);
			Object handlerObject = handlerClass.newInstance();
			handler = (RequestHandler) handlerObject;
	    	handler.setModel(model);
	    	handler.setMessageService(messageService);
		} catch (Exception e) {
			throw new RuntimeException("Deze pagina bestaat niet!!!!");
		}
		return handler;
	}


}
