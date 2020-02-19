/*
This class will be our main gameplay loop (for now). 
It will later include a turn counter (turn based) and listen for input from the player. 
Think of simulation type games such as the Sims. This is a very simple version. 
We will increase the complexity later.
*/
public class PartySim{
	
	private Place partyLocation;
	private PersonList partyPeople; 

	// Its a party, only simulated. Generate some guests, assign them to mingle, then print them out in the end (including who they talked to). 
	
	// method mingle()
	// main game step, called to start the scene. 
	// each person selects a person to talk to. If there is an even number of people, 
	// each person "talks" to one other person. 

	// Special case: 
	// If there is an odd number of people, one group has three people and each of them 
	// should record that they "talked to" the other two. 

	// Make sure you are setting both directions at the same time (so person A talking 
	// to person b would mean person A would have B added to their talkedTo list, while 
	// person B would add Person A to the talkedTo list. ) % 2 can be used to help you 
	// know if the number is odd or even. 

	// Calling mingle() should make each person should talk to a different person if 
	// they are able. 
	// If they are not able, they can talk to each other again, however, they should 
	// not add each other to their lists again. They should also not talk to themselves. 
	
	// You can use the RandomGenerator class to select a person from the person list. 
	// You should verify that the two Person objects are different and reselect a person
	// until you have a unique one. 
	public static void main(String[] args){

		PartySim sim = new PartySim();

		sim.partyPeople = PartySim.createPeople(5); // Can access private variable ONLY because we are in the same class. 
        sim.partyLocation = PartySim.createPlace(1);

		// Start the simulation, again a little clunky
		sim.mingle();

		System.out.println(" === Final Output === ");
		System.out.println(sim.wholePartyToString());

		// Eg, should test on other list sizes, at least {0,1,2,3,4,5}
		//	PersonList list = createPeople(4);	

	}
	
	// * Don't need a place to party at because it is now an instance method
	// although we might want to seperate multiple party places and activate them seperately. 
	// This is a little simpler then what you needed to do. 
	private void mingle(){
		PersonList currentGuests = partyPeople.clone();
		while(currentGuests.size() > 1){
			stepMingle(currentGuests);
			int removeIndex = RandomGenerator.randomRoll(0, currentGuests.size());
			Person toRemove = currentGuests.getPerson(removeIndex);
			currentGuests.removePerson(toRemove);
		}
	}

	// One timestep of mingling. Everyone talks to each other once. 
	// Note: I skipped the last trio, even tho I asked for it. Get over it. 
	private void stepMingle(PersonList source){
		PersonList clone = source.clone();

		// Shuffle the order
		clone.shuffle();

		for(int i =0; i < clone.size()-1; i = i + 2){
			// tell the two people to talk to each other
			// using an overloaded method that accepts two parameters. 
			clone.getPerson(i).talkedTo(clone.getPerson(i + 1), true); 

			/*
			// fancy version of this 
			Person p1 = clone.getPerson(i);
			Person p2 = clone.getPerson(i+1);
			p1.talkedTo(p2);
			p2.talkedTo(p1);

			// Which is more clear? easier to read? 
			*/
		}
		
	}

	private void updateLoop(){

		while(true){


			StdDraw.show(20);
		}
	}

	// Print out a list of all Persons at the Place. 
	// Print out the people they each talked to as well as friends (if you got that far)
	private String wholePartyToString(){
		/*
		Some of you may have tried something like this: 
		System.out.println(" --- Party of " + partyPeople.size() + " ---");

		// it should be well formatted and clear for full marks. 
		for(int i = 0; i < partyPeople.size(); i++){
			// get reference (optional)
			Person nextPerson = partyPeople.getPerson(i); 
			// Output the person. 
			System.out.println("Person(" + i + "): " + nextPerson.toString());

			// Could be in one line as well. 
			// I like to be able to check the getPerson return code as an object though, espectially in development 
			//System.out.println("Person(" + i + "): " + partyPeople.getPerson(i).toString());
		}
	*/
		// Or just this: 	
		// actually this, originally I planned on storing the personlist in teh place
		// but changed my mind when I made PartySim an instance method and had to adapt. 
		return partyPeople.longToString();
	}
	
	// ----- Static Utility methods -----  
	// Create a new list of people by selecting from the names array. 
	// Create int number of people, 
	public static PersonList createPeople(int number){
		PersonList list = new PersonList();

		// Create a new set of Person objects stored in list. 
		for(int i = 0; i < number; i++){
			Person tempPerson = new Person( RandomGenerator.getRandomName());
			list.addPerson(tempPerson);
		}

		return list; // Return the list / array
	}

	// I only made it a method because I want to expand it later. 
	// 		[ ] Generate appropriate Items from file to add to the place. 
	public static Place createPlace(int index){
		
		// Original test, but instead moved this Map get board into
		// Place class and also Map class so now it is simpler. 
		//Map m = new Map(Map.getBoard(index));
		
		Place tempPlace = new Place(index);

		System.out.println("New Place Created: " + tempPlace);
// 		[ ] Next task
// 		System.out.println(tempPlace.mapToString());

		return tempPlace;
	}

	//  ----- Stretch goal - Major Feature [ ] ----- 
		// Add interests and friends

		// Create a new PersonList variable for each person, called friends. 
		// If two people talk to each other and have at least one of the same interests, 
		// add them to each others friends list (in addition to the talkedTo lists). 

		// Again at the end, print out all the people with their lists of talkedTo, 
		// interests and friends. 

			// Notes: You will likely want to create some methods to help facilite these tasks. 
			// Break down what you have to do into smaller bite sized pieces. 
			// Look where you can reuse existing code (eg PersonList will get reused many times.)
			// You should also add additional methods to other classes 
			// (such as adding new Constructors to Person to accept interests. )


}