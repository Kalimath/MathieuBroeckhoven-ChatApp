package domain;

import java.util.ArrayList;
import java.util.List;

import db.PersonRepository;
import db.PersonRepositoryStub;

public class PersonService {
	private PersonRepository personRepository = new PersonRepositoryStub();

	public PersonService(){
	}
	
	public Person getPerson(String personId)  {
		return getPersonRepository().get(personId);
	}

	public List<Person> getPersons() {
		return getPersonRepository().getAll();
	}

	public void addPerson(Person person) {
		getPersonRepository().add(person);
	}

	public void updatePersons(Person person) {
		getPersonRepository().update(person);
	}

	public void deletePerson(String id) {
		getPersonRepository().delete(id);
	}
	
	public Person getAuthenticatedUser(String email, String password) {
		return getPersonRepository().getAuthenticatedUser(email, password);
	}

	public void addFriend(String userId, String friendId) {getPersonRepository().addFriend(userId, friendId);}

	public void removeFriend(String userId, String friendId) {getPersonRepository().removeFriend(userId,friendId);};

	public ArrayList<Person> getAllFriends(String userId) {return getPersonRepository().getAllFriends(userId);}

	private PersonRepository getPersonRepository() {
		return personRepository;
	}
}
