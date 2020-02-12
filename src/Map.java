// A data class for storing a map of a Place. 
// This will handle the 2d array of art types for us. 
public class Map{


  private char[][] currentMap;

  // in pixels
  private int mapSize = 512; // in pixels
  private int tileSize = 64; // The tile size

  // Load a prebuilt map by index
  public Map(int index){

  }

  // Generate the map based on the template
	public Map(char[][] mapTemplate){

	}

	// Take each char in the array and draw the corresponding image. 
	// laying them out in a grid might be tricky, you can keep a fixed size for now
	// of 64 px images on a 512 px map
	public void drawMap(){
		
	}

  

	// Testing Data for now, we will replace this later
	 // Add more if you want
	private static String[][] testBoards = {
    { "X.X",
      ".X.",
      "X.X"},

    { ".......",
      "..X.X..",
      ".X...X.",
      "..XXX..",
      "......."},

    { "P.XX",
      "X.XX",
      "X..X",
      "XXXX"},

      {"XXXXXXXX",
      "X......X",
      "X...P..X",
      "X......X",
      "X..1...X",
      "X......X",
      "X......X",
      "XXXXXXXX"},

      // 16xx16 too big, needs scaling
    { "XXXXXXXXXXXXXXXX",
      "X..............X",
      "X...P..........X",
      "X..............X",
      "X..........1...X",
      "X..............X",
      "X..............X",
      "X..............X",
      "X..2...........X",
      "X..............X",
      "X........3.....X",
      "X..............X",
      "X....4.........X",
      "X..............X",
      "X..............X",
      "XXXXXXXXXXXXXXXX"}
	};

	// This will convert the selected test case from an array of Strings into
  // the 2D array of booleans used in Assignment 2.
  private static char[][] getBoard(int index){
      // just a test return a num 2d array
      char[][] theBoard = new char[2][2];
      return theBoard;
  }

// Debugging
  public static void main(String[] args){
    testMaps();
  }

    // Debugging: 
  public static void testMaps(){
    Map m = new Map(Map.getBoard(0));
    m.drawMap();
    StdDraw.show(2000);
    StdDraw.clear();

    m = new Map(Map.getBoard(1));
    m.drawMap();
    StdDraw.show(2000);
    StdDraw.clear();

    m = new Map(Map.getBoard(2));
    m.drawMap();
    StdDraw.show(2000);
    StdDraw.clear();

    m = new Map(Map.getBoard(3));
    m.drawMap();
    StdDraw.show(2000);
    StdDraw.clear();

    m = new Map(Map.getBoard(4));
    m.drawMap();
    StdDraw.show(2000);
    StdDraw.clear();

    // This one should fail gracefully (ie not crash)
    /*
    m = new Map(Map.getBoard(5));
    m.drawMap();
    StdDraw.show(2000);
    StdDraw.clear();
    */
  }

}