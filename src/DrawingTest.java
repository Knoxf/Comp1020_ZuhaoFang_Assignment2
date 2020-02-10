// Just an example of some drawing tests. 
public class DrawingTest{
	

	public static void main(String[] args){

		System.out.println("Drawing Test:");
		// Set the canvas size (optional but i want even sides for tiling the art.)


		StdDraw.show(100); // wait 100 ms
      	StdDraw.clear(); // clear the canvas
      	StdDraw.setPenColor(StdDraw.RED);
      	StdDraw.filledRectangle(0.5,0.5,0.2,0.2); // red square test

      	StdDraw.show(100); // wait 200 ms

      	// Images:
      	StdDraw.picture(0.5,0.5, "Person0.png");
      	StdDraw.show(100); // wait 100 ms, nothing happens after so it will not be removed until clear is called. 

      	// Centered text
      	StdDraw.text(0.2,0.2,"Hello Text");
      	StdDraw.setPenColor(StdDraw.BLUE);
      	StdDraw.textLeft(0.2,0.1,"Left Aligned Text");
      	StdDraw.line(0.2,0.2,0.2,0.1);

      	StdDraw.show(200);

      	// start an animation loop
      	animationLoop();


	}

	public static void animationLoop(){
		// Variables to manipulate (to animate) --- 

		// Angle controls. 
		double angle = 0;
		boolean rotateCounterClockwise = false;

		// Movement controls. 
		boolean movingRight = true;
		double xPos = 0.1;
		double yPos = 0.8;

		// Art Refernces. 
		String file = "Person0.png";

		// Normally you would avoid this but its how you do a realtime system. 
		while(true){
			StdDraw.picture(xPos, yPos, file, angle);
			StdDraw.show(20);

			// update rotation
			if(rotateCounterClockwise){
				angle += 1.0;
			}else{
				angle-= 1.0;
			}

			// check max rotation and rotate back
			if(angle > 5.0 || angle < -5.0 ){
				rotateCounterClockwise = !rotateCounterClockwise; // reverse the flag to turn the other way. 
			}

			// Movement
			if(movingRight){
				xPos += .01;
			}else{
				xPos -= .01;
			}

			// max edge (.1 from the side of the canvas)
			if( xPos < 0.1){
				movingRight = true;
			}else if(xPos > 0.9){
				movingRight = false;
			}

		}



		//public static void picture(double x, double y, String s, double degrees) {
	}
}

/*    // (some) useful StdDraw methods for quick reference. 
		// See the class itself for more details (and variations). 
	public static void setPenColor(Color color) { // Use StdDraw.RED etc, see StdDraw file for details. 
    public static void setPenColor(int red, int green, int blue) {

    public static void line(double x0, double y0, double x1, double y1) {
    public static void arc(double x, double y, double r, double angle1, double angle2) {

	public static void setPenRadius(double r) {

	public static void point(double x, double y) {
    public static void circle(double x, double y, double r) {
    public static void square(double x, double y, double r) {
    public static void filledSquare(double x, double y, double r) {

    public static void picture(double x, double y, String s) {
    public static void picture(double x, double y, String s, double degrees) {
	public static void picture(double x, double y, String s, double w, double h) {
    public static void picture(double x, double y, String s, double w, double h, double degrees) {

    public static void text(double x, double y, String s) {
    public static void textLeft(double x, double y, String s) {
    public static void textRight(double x, double y, String s) {
    public static void show(int t) //      * @param t number of milliseconds
    private static void draw() 
    public static void save(String filename) 

	// Input
    public static boolean mousePressed() 
    public static double mouseX() 
    public static double mouseY() 

     * See http://download.oracle.com/javase/6/docs/api/java/awt/event/KeyEvent.html
     * for a description of key codes.
     * @return true if keycode is currently being pressed, false otherwise

    public static boolean isKeyPressed(int keycode)
*/