// A place represents a location and can contain a list of people
// Later it will also have Things. 
// It also holds the map which renders the background. 
public class Place{

	// --- Instance Variables ---
	// Descriptors
	private String name;
	private String description;
	// Objects stored by Place (People at the Place in this case)
	private PersonList people;
	private Map theMap;
	private PersonList People;



	// Enable debugging mode for this script
	private final boolean DEBUG_MODE = false;

	// --- Variations of Place constructor ---
	// Random Generated Constructor, calls other constructor. 
	public Place(){
		name = RandomGenerator.getRandomLocationName();
		description = RandomGenerator.getRandomPlaceDescription();
		people = new PersonList();

	}

	// Constructor, accepts a name and description, both type String
	public Place(String newName, String newDescription){
		name = newName;
		description = newDescription;
		people = new PersonList();

	}

	//Constructor, accepts name, description,map and PersonList
	public Place(String name, String description, Map theMap, PersonList People){
		this.name = name;
		this.description = description;
		this.theMap = theMap;
		this.People = People;
	}



	// --- Strings and Descriptions ---
	// toString simply returns the name
	public String toString(){
		return name; 
	}

	// Description
	// Accessor for description
	public String getDescription(){
		return description;
	}

	// Assign a new description (replace the old one)
	public void setDescription(String newDescription){
		description = newDescription;
	}

	// --- People ---
	// People at this location
	public String getPeople(){
		return people.toString();
	}

	// Add a person to the people List
	public void addPerson(Person toAdd){
		people.addPerson(toAdd);
	}

	// Does this place contain a given person. 
	public boolean containsPerson(Person toFind){
		return people.containsPerson(toFind);
	}

	// How many people are at this place. 
	public int personCount(){
		return people.size();
	}

	// Attempts to remove the given person from the list. 
	// returned true if it succeeds and false if the person does not exist
	public boolean removePerson(Person toRemove){
		// Check if person exists in the list
		boolean contained = people.containsPerson(toRemove);
		Person removed = null; 	// Was the person returned from Remove?

		// If the person was found, then remove them, otherwise dont
		if( contained ){
			removed = people.removePerson(toRemove);
		}

		// -------- Debugging ---------
		if( contained){
			if(removed != null){
				System.out.println("DEBUG (Place): Person: " + removed.toString() + " was removed");
			}else{
				System.out.println("DEBUG (Place): Error occured, person found with contains but not returned from removePerson method");
			}
		}else{
			System.out.println("DEBUG (Place): Person not found on list, can't be removed");
		}

		// Brackets are optional but helps clarify the logic for you while you are learning.
		return (contained && removed != null);
	}

	// Returns a count of the current number of people at a given place. 
	public int countPeople(){
		return people.size();
	}

	// v0 - Place is a location
	// v1 - Place contains a list of Things and a list of Persons
	// v2 - replace with Lists of both types. 
	// next version -  building contains rooms, furnature and items and person are stored in rooms 	

	// method to list/retrieve all rooms, all items, all people

	// print summary different types
	/*
	By Room, Person, Things. 

	*/
}	
