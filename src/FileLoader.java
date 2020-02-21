import java.util.Scanner;
import java.io.*; // IO and Exceptions

public class FileLoader{

	private static boolean DEBUG_MODE = true;

	// Test methods
	public static void main(String[] args){
		/*
		PersonList list = loadPeople();
		System.out.println("Load from String array");
		System.out.println(list.toString());

		list = loadPeople("TestPeople.txt");
		System.out.println("Load from File");
		System.out.println(list.toString());

		 */
		loadPeople("testPeople.txt");
	}

	private static String[] testPeople = {
		"Person1,Fairly Interesting",
		"Person2,More Testing of People",
		"Another Person,Might have many words or few",
		"Valid but empty description,"
	};

	public static PersonList loadPeople(){
		PersonList theNewPersonList;

		return null;

	}

	public static PersonList loadPeople(String fileName){
		BufferedReader fileIn;
		String lineIn;
		Scanner lineScanner;
		String[] loadedPeople = new String[100];
		try{
			fileIn = new BufferedReader(new FileReader(fileName));
			lineIn = fileIn.readLine();
			int totalLine = 1;
			while(lineIn != null){
				totalLine ++;
				loadedPeople = new String[totalLine];
				loadedPeople[totalLine-1] = lineIn;
				lineIn = fileIn.readLine();
			}
		}catch(IOException e){
			System.out.println(e.getMessage());
		}
		for(int i=0;i<loadedPeople.length;i++){
			System.out.println(loadedPeople[i]);
		}
		return null;
	}

}