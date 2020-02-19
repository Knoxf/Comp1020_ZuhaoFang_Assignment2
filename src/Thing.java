// A Thing is an Object that can be carried by a Person or put in a Place. 
public class Thing{

	// Instance variables. 
	private String name; // Note: So far name must be set in Constructor
	private String description;

	// Alternate way of assigning variables, using "this" keyword
	public Thing(String name, String description){
		this.name = name;
		this.description = description;
	}

	// returns the name of the Thing
	public String toString(){
		return name;
	}

	// "Accessor" method for description
	public String getDescription(){
		return description;
	}

	// Alternate way of assigning variables, using "this" keyword
	// "Mutator" method for description
	public void setDescription(String description){
		this.description = description;
	}

}