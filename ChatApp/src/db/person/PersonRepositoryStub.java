package db.person;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import domain.Person;
import domain.Role;

public class PersonRepositoryStub implements PersonRepository {
    private Map<String, Person> persons = new HashMap<String, Person>();

    public PersonRepositoryStub() {
        Person administrator = new Person("bib@ucll.be", "t", "Bib", "Liothekaris", Role.BIB);
        add(administrator);
        Person jan = new Person("jan@ucll.be", "t", "Jan", "Janssens", Role.LID);
        add(jan);
        Person an = new Person("an@ucll.be", "t", "An", "Cornelissen", Role.LID);
        add(an);
        Person me = new Person("mathieu@ucll.be","t","Mathieu","Broeckhoven", Role.LID);
        add(me);
        jan.addFriend(administrator.getUserId());
        jan.addFriend(an.getUserId());
    }

    public Person get(String personId) {
        if (personId == null) {
            throw new IllegalArgumentException("No id given");
        }
        return persons.get(personId);
    }

    public List<Person> getAll() {
        return new ArrayList<Person>(persons.values());
    }

    public void add(Person person) {
        if (person == null) {
            throw new IllegalArgumentException("No person given");
        }
        if (persons.containsKey(person.getUserId())) {
            throw new IllegalArgumentException("User already exists");
        }
        persons.put(person.getUserId(), person);
    }

    public void update(Person person) {
        if (person == null) {
            throw new IllegalArgumentException("No person given");
        }
        persons.put(person.getUserId(), person);
    }

    @Override
    public void addFriend(String userId, String friendId) {
        this.persons.get(userId).addFriend(friendId);
    }

    @Override
    public ArrayList<Person> getAllFriends(String userId) {
        if (this.persons.containsKey(userId)) {
            List<Person> friends = new ArrayList<>();
            for (String id : this.persons.get(userId).getFriends()) {
                if (this.persons.containsKey(id)) {
                    friends.add(this.persons.get(id));
                }

            }
            return (ArrayList<Person>) friends;
        } else {
            return new ArrayList<>();
        }

    }

    @Override
    public void removeFriend(String userId, String friendId) {
        if (this.persons.containsKey(userId)) {
            this.persons.get(userId).deleteFriend(friendId);
        }
    }

    public void delete(String personId) {
        if (personId == null) {
            throw new IllegalArgumentException("No id given");
        }
        persons.remove(personId);
    }

    public Person getAuthenticatedUser(String email, String password) {
        Person person = get(email);

        if (person != null && person.isCorrectPassword(password)) {
            return person;
        } else {
            return null;
        }
    }
}
