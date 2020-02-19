// Dylan Fries 2019
// PersonList is a partially full array of Person Objects. 
public class PersonList{
	
	private Person[] people; // array of Persons
	private int currentCount = 0; // current index of Persons
	private int maxSize = 100; // max number of Person object in Persons

	// Default constructor
	// set max array size, create array
	public PersonList(){
		people = new Person[maxSize];
		currentCount = 0;
	}

	public int size(){
		return currentCount;
	}

	// Add the next Person to the array
	public void addPerson(Person newPerson){
		people[currentCount] = newPerson;
		currentCount++; // add to array then update
	}

	// Add the next Person to the array
	public void addPerson(Person newPerson, boolean skipDuplicates){
		if( skipDuplicates){
			// already found, skip
			if(findIndex(newPerson) < 0 ){
				addPerson(newPerson); // call the other method. 
			}
		}else{
			addPerson(newPerson);
		}
	}

	// Access the current person. 
	public Person getPerson(int index){
		if(index >= 0 && index < currentCount){
			return people[index];
		}else{
			System.out.println("Person out of range");
		}
		return null;
	}

	// Clone the personlist
	public PersonList clone(){
		PersonList cloned = new PersonList();
		for(int i = 0; i < currentCount;i++){
			cloned.addPerson(people[i]);
		}
		return cloned;
	}

	// Randomize the order
	public void shuffle(){
		for(int i = 0; i < currentCount; i++){
			int j = RandomGenerator.randomRoll(0, currentCount);
			Person temp = people[i];
			people[i] = people[j];
			people[j] = temp;
		}
	}

	// Find the index of a given person
	// can be used by both containsPerson and removePerson methods
	private int findIndex (Person searchKey){
		int i = 0;
		boolean found = false;
		int foundIndex = -1;
		// Iterate the array looking for a specific object and return that objects index
		while(!found && i < currentCount){
			if(people[i] == searchKey){
				found = true;
				foundIndex = i;
			}
			i++;
		}

		return foundIndex;

		/*
		// alternate version
		while(!found && i < currentCount){
			if(people[i] == searchKey){
				found = true;
			}else{
				i++;
			}
		}
		return i;
		*/

	}

	// People should be unique within the system so you can compare directly
	public boolean containsPerson(Person searchKey){
		boolean found = false;
		// Reuse our findIndex method
		int index = findIndex(searchKey);

		if(index > -1){
			found = true;
		}

		return found;
	}

	// Should only be called if a given person is known to exist in the list
	public Person removePerson(Person searchKey){
		Person temp = null;

		// Reuse our findIndex method
		int index = findIndex(searchKey);

		// iterate through the array, removing the target person and move the rest over
		if(index > -1){
			temp = people[index];

			System.out.println("index: " +index + " temp: " + temp.toString());

			// iterate from the top, copying everyone over one position
			for(int i = index; i < currentCount - 1; i++ ){
				people[i] = people[i+1];
			}
			currentCount--;
			people[currentCount] = null;
		}else{
			System.out.println("Error, do not remove a person without first checking they exist");
		}

		return temp;
	}

	// Print the whole Person list as a String
	// formatting and returning all the strings
	public String toString(){

		String list = "[";		

		if(currentCount == 0){
			return "[EMPTY]";
		}

		// Note you are using current Index not max here. 
		for(int i = 0; i < currentCount-1; i++){
			list += people[i].toString() + ", ";
		}

		// handle the end of the list
		list+= people[currentCount-1].toString() + "]";

		return list;
	}

	// Print the whole Person list as a String
	// formatting and returning all the strings
	public String longToString(){

		String st = "=====================\n";
				// Since we already have a toString, reuse that for the header
		st += toString() + "\n";

		// all people with full list of people they talked to in turn. 
		for(int i = 0; i < currentCount; i++){
			st += people[i].longToString() + "\n";
		}


		return st;
	}
	
}