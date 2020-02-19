public class TesterA1{
	
	public static void main(String[] args){
		testsPhase1();

		testsPhase2();

		testsPhase4();

		testsPhase5();
	}

	

	// Basic tests to run after Phase 1
	public static void testsPhase1(){
		System.out.println("\n ========== Phase 2 Tests ========== ");
		Person person1 = new Person("Person");
		Place place1 = new Place("Place", "Place Description");
		Thing thing1 = new Thing("Thing", "Thing Description");

		// copy references
		Place placePointer2 = place1;
		Thing thingPointer2 = thing1;

		System.out.println("Person Name: " + person1.toString());
		System.out.println("Place Name: " + place1.toString() + " Description: " + place1.getDescription());
		System.out.println("Thing Name: " + thing1.toString() + " Description: " + thing1.getDescription());
	
		place1.setDescription("New Description for Place");
		thing1.setDescription("New Description for Thing");
		// Edited objects
		System.out.println("Place Name: " + place1.toString() + " Description: " + place1.getDescription());
		System.out.println("Thing Name: " + thing1.toString() + " Description: " + thing1.getDescription());

		// Tests regarding correctly updating the Description
		// Tests that you didn't create a new Object, but updated the old one. (why do these tests work? )
		if( thing1 == thingPointer2 ){
			System.out.println("Thing object was correctly updated");
		}else{
			System.out.println("Thing object was incorrectly updated. You should be changing the existing object, not creating a new one.");
		}
		// Place object test
		if( place1 == placePointer2 ){
			System.out.println("Place object was correctly updated");
		}else{
			System.out.println("Place object was incorrectly updated. You should be changing the existing object, not creating a new one.");
		}

	}
	
	// tests the lists of Persons, adding and removing them
	public static void testsPhase2(){	
		System.out.println("\n ========== Phase 3 Tests ========== ");
		// Test Lists
		PersonList list = new PersonList();
		System.out.println("List 0: " + list.toString());
	
		Person p0 = new Person("Person 0");
		list.addPerson(p0);
		System.out.println("List 1: " + list.toString());

		Person p1 = new Person("Person 1");
		list.addPerson(p1);
		System.out.println("List 2: " + list.toString());

		Person p2 = new Person("Person 2");
		list.addPerson(p2);

		System.out.println("List 3: " + list.toString());
		System.out.println("Contains should be true: " + list.containsPerson(p2));

		list.removePerson(p2);
		System.out.println("List 2: " + list.toString());

		list.removePerson(p0);
		System.out.println("List 1: " + list.toString());

		list.removePerson(p1);
		System.out.println("List 0: " + list.toString());
	}
	
	// tests the lists of Persons in a Place
	public static void testsPhase4(){	
		System.out.println("\n ========== Phase 4 Tests ========== ");
		Place place1 = new Place("Test Location", "An empty place suitable to testing methods on");

		Person person1 = new Person("Person1");
		Person person2 = new Person("Person2");
		Person person3 = new Person("Person3");
		Person person4 = new Person("Person4");

		System.out.println("Test Place number of People (should be 0): "+ place1.countPeople());
		// Test 1
		place1.addPerson(person1);
		System.out.println("Test Place number of People (should be 1): "+ place1.countPeople());
		// Test 2 people
		place1.addPerson(person2);
		System.out.println("Test Place number of People (should be 2): "+ place1.countPeople());

		System.out.println("People Currently at Place: " + place1.getPeople());

		// Test 2 people
		boolean removed = place1.removePerson(person2);
		System.out.println("Person removed (should be true): " + removed);
		System.out.println("Test Place number of People (should be 1): "+ place1.countPeople());

		// Adding person 3. List should now be 1 & 3
		place1.addPerson(person3);
		System.out.println("Test Place number of People (should be 2): "+ place1.countPeople());
		System.out.println("People Currently at Place: " + place1.getPeople());

		removed = place1.removePerson(person4);
		System.out.println("Person not in list removed (should be false): " + removed);
		System.out.println("Test Place number of People (should be 2): "+ place1.countPeople());
		System.out.println("People Currently at Place: " + place1.getPeople());
	
	}

	public static void testsPhase5(){

		System.out.println("\n ========== Phase 5 Tests ========== ");
		// Create the list
		PersonList list = new PersonList();

		Person p0 = new Person("Person 0");
		list.addPerson(p0);

		Person p1 = new Person("Person 1");
		list.addPerson(p1);

		Person p2 = new Person("Person 2");
		list.addPerson(p2);

		System.out.println("List 3: " + list.toString());

		// Test Clone and shuffle
		PersonList cloned = list.clone();

		System.out.println("Cloned List");
		System.out.println(cloned.toString());

		System.out.println("Shuffled Cloned List");
		cloned.shuffle();
		System.out.println(cloned.toString());
		System.out.println("Original List: " + list.toString());

	}
}