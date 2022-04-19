import processing.core.PApplet;
import processing.core.PImage;

public class Sketch extends PApplet {
	
  /**
  * A program Sketch.java that animates a ball and animates a Pacman image bouncing around in a non-linear path.
  * @author: D. Gu 
  */

  // Set global variables
  PImage imgBackground;
  PImage imgPacMan;
  float fltMoveX;
  float fltMoveY;
  float fltCircleX;
  float fltMovePacX;
  float fltMovePacY;
  float fltPacX;
  float fltPacY;

  /**
   * Sets the size of the call
   * 
   * @param  nothing
   * @return nothing
   * 
   */
  public void settings() {
    size(600, 600);
  }

  /**
   * Initializes values for global variables
   * 
   * @param nothing
   * @return nothing
   * 
   */
  public void setup() {
    // Initialize values for variables
    fltCircleX = 15;
    fltMoveX = 2;
    fltMoveY = 2;
    fltMovePacX = 2;
    fltMovePacY = 2;    
    fltPacX = 30;
    fltPacY = 0;

    // Load background image and make it the same size as width/height
    imgBackground = loadImage("Wooden.jpg");
    imgBackground.resize(imgBackground.width, imgBackground.height);
    
    // Load Pacman image and resize it
    imgPacMan = loadImage("Pacman_HD.png");
    imgPacMan.resize(imgPacMan.width / 40, imgPacMan.height / 40);
    
  }

  /**
   * Draws everything inside the method 60 times per second
   * 
   * @param nothing
   * @return nothing
   * 
   */
  public void draw() {
	  
    // Draws the Background image
    image(imgBackground, 0, 0);
  
    // Draw a circle with x coordinate fltCircleX
    ellipse(fltCircleX, 200, 30, 30);

    // Draw the Pacman image and make sure it has the fltPacX and fltPacY coordinates
    image(imgPacMan, fltPacX, fltPacY);

    // Modify the state of the circle's x coordinate 
    // Make the Pacman image move in a parabolic path 
    fltCircleX = fltCircleX + fltMoveX;
    fltPacX = fltPacX + fltMovePacX;
    fltPacY = fltPacY + fltMovePacY;
    fltMovePacY = (1 + (float)0.02 * fltPacY) * fltMovePacY / Math.abs(fltMovePacY);

    // Make sure Pacman doesn't leave the screen
    if(fltPacX < 0 || fltPacX > 555){
      fltMovePacX = fltMovePacX * -1;
    }
    
    if(fltPacY < 0 && fltMovePacY < 0  || fltPacY > 555 && fltMovePacY > 0){
      fltMovePacY = fltMovePacY * -1;
    }

    // Make sure the circle doesn't leave the screen
    if(fltCircleX < 15 || fltCircleX > width - 15) {
      fltMoveX = fltMoveX * -1;
    }
  }
  

}