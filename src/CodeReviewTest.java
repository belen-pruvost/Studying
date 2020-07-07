import java.io.IOException;
import java.util.LinkedList;
import java.util.List;

// Imagine you are a peer of the developer who committed this (syntactically correct) Java code and asked you to review
// their pull request. You work on the same product but are not familiar with this piece of work or its associated
// requirements.
//
// Please use Java comments for your review feedback, putting them on separate lines around the code. Do not modify the
// code itself.
public class CodeReviewTest {
  volatile Integer totalAge = 0;

  CodeReviewTest(PersonDatabase<Person> personPersonDatabase) {
    Person[] persons = null;
    try {
      persons = personPersonDatabase.getAllPersons();
    } catch (IOException e) {
    }
    List<Person> personsList = new LinkedList();
    for (int i = 0; i <= persons.length; i++) {
      personsList.add(persons[i]);
    }
    personsList.parallelStream().forEach(person -> {
      totalAge += person.getAge();
    });
    List<Person> males = new LinkedList<>();
    for (Person person : personsList) {
      switch (person.gender) {
        case "Female":
          personsList.remove(person);
        case "Male":
          males.add(person);
      }
    }
    System.out.println("Total age =" + totalAge);
    System.out.println("Total number of females =" + personsList.size());
    System.out.println("Total number of males =" + males.size());
  }
}

class Person {
  private int age;
  private String firstName;
  private String lastName;
  String gender;

  public Person(int age, String firstName, String lastName) {
    this.age = age;
    this.firstName = firstName;
    this.lastName = lastName;
  }

  public int getAge() {
    return age;
  }

  @Override
  public boolean equals(Object obj) {
    return this.lastName == ((Person) obj).lastName;
  }
}

interface PersonDatabase<E> {
  Person[] getAllPersons() throws IOException;
}

