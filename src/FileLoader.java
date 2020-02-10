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
	

}