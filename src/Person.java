// A person represents (as you might expect) a single Person. There should 
// only ever be one instance of each person at a time. 
public class Person{
	// things you might want to add if you feel ambitious.. 
	// name
	// backstory
	// alibi
	// itemlist

	private String name; // Name of the person
	private String description; // Description of the person. 

	private PersonList talkedTo; // list of everyone that they talked to at the party. 


	public Person(String name){
		this.name = name;
		talkedTo = new PersonList();
		description = RandomGenerator.getRandomPersonDescription();
	}

	// basic constructor.
	public Person(String newName, String newDescription){
		name = newName;
		description = newDescription;
		talkedTo = new PersonList();
	}



	// ------- Talking and relationships -------
	// has a person already talked to a given person at least once. 
	public boolean hasTalkedTo(Person other){
		// Search through the list of people a person has talked to
		// return true if they have already talked to them at least once. 
		return talkedTo.containsPerson(other);
	}

	// This is the version I am using
	// It is a bit confusing with both methods and ALSO the 
	// list has the same name, oops. 
	public void talkedTo(Person other, boolean alsoSetInverse){
		talkedTo.addPerson(other, true);
		if(alsoSetInverse){
			other.talkedTo.addPerson(this, true);
		}
	}

	// Return only the name for now. 
	public String toString(){
		return name;
	}

	// include everyone they talked to as well 
	public String longToString(){
		return name + " talked to " + talkedTo.toString(); // reuse our methods again! save us some work!
	}
	
	// "Accessor" method for description
	public String getDescription(){
		return description;
	}

	// Alternate way of assigning variables, using "this" keyword
	// "Mutator" method for description
	// For now I am overwriting the old description. This could be improved
	// by allowing for appending. 
	public void setDescription(String description){
		this.description = description;
	}
}