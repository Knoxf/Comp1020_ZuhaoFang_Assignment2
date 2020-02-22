import javafx.scene.chart.ScatterChart;

import java.util.Scanner;
import java.io.*; // IO and Exceptions

public class FileLoader{

	private static boolean DEBUG_MODE = true;

	// Test methods
	public static void main(String[] args){
		PersonList list = loadPeople();
		System.out.println("Load from String array");
		System.out.println(list.toString());

		list = loadPeople("TestPeople.txt");
		System.out.println("Load from File");
		System.out.println(list.toString());

	}

	private static String[] testPeople = {
		"Person1,Fairly Interesting",
		"Person2,More Testing of People",
		"Another Person,Might have many words or few",
		"Valid but empty description,"
	};

	public static PersonList loadPeople(){
		PersonList theNewPersonList = new PersonList();   // return PersonList
		Person containPerson;    // The new person object
		String newName;       // the new Person name
		String[] temPerson;   // hold the new person

        // change the string array to the person and store in the personList
		for(int i=0;i<testPeople.length;i++){
			temPerson = testPeople[i].split(",");
			newName = temPerson[0];
			containPerson = new Person(newName);
			theNewPersonList.addPerson(containPerson);
		}

		return theNewPersonList;

	}

	public static PersonList loadPeople(String fileName){
		BufferedReader fileIn;    //the reader
		String lineIn;          // the line that reader get from file
		String[] loadedPeople = new String[4];   // total array length
		Person containPerson;    // to hold person
		PersonList filePeople = new PersonList();   // the return PersonList
  		String newName;                //the name that get from file
		String[] temPerson;    // hold each person

		//load person from gived file and stone it in string array
		try{
			fileIn = new BufferedReader(new FileReader(fileName));
			lineIn = fileIn.readLine();
			int totalLine = 1;
			while(lineIn != null){
				totalLine ++;
				loadedPeople[totalLine-2] = lineIn;
				lineIn = fileIn.readLine();
			}
		}catch(IOException e){
			System.out.println(e.getMessage());
		}

		// change the string array to the person and store in the personList
		for(int i=0;i<loadedPeople.length;i++){
			temPerson = loadedPeople[i].split(",");
			newName = temPerson[0];
			containPerson = new Person(newName);
			filePeople.addPerson(containPerson);
		}

		return filePeople;
	}

	public static Person loadPerson(int index){
		Person containPerson;    // The new person object
		String newName;       // the new Person name
		String[] temPerson;   // hold the new person

		//store the index number of people into the person object
		temPerson = testPeople[index].split(",");
		newName = temPerson[0];
		containPerson = new Person(newName);
		return containPerson;
	}

	private static Person parsePersonString(String aPerson) throws Exception{
		String theName;
		String theDescription;
		String[] theNameAndDescri;
		Person personAndDescri;

		theNameAndDescri = aPerson.split(",");

		theName = theNameAndDescri[0];
		theDescription = theNameAndDescri[1];

		for(int i=0;i<theNameAndDescri.length;i++){   //catch exception
			if(theNameAndDescri[i] == null){
				throw new Exception("change error");
			}
		}

		personAndDescri = new Person(theName,theDescription);
		return personAndDescri;
	}

}