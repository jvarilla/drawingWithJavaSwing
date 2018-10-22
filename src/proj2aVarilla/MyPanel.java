/*
 * Name: Joseph Varilla
 * Project Name: Drawing in JPanel
 * Project Number: 2
 * Submission Date 9/21/18
 * 
 * IT 313 | Project2: Drawing in JPanel
 * About: 
 * -Renders and image of a shark 
 *  titled "Blue Demon Shark"
 * -Renders 5-15 randomly positioned and colored
 *  fish
 * -Renders the Shark with either its Mouth open or closed
 *  at random
 * 
 * NOTE: For best viewing experience: run the program
 * and slowly adjust the vertical size of the frame to
 * create an animated effect that simulates the Shark Swimming
 * and opening/closing its mouth
 */
package proj2aVarilla;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.Random;
public class MyPanel extends JPanel{
	public MyPanel( ) {
		setBackground(new Color(0x2471A3));//A dark blue/gray color
	}
	
	public void paintComponent(Graphics g) {
	    super.paintComponent(g);
        
       //Draw random background fish
       Random r = new Random();
       
       //Array of possible colors for random fish
       final Color[] fishColors = {Color.blue, Color.red, 
                                    Color.black, Color.white};
     
       //Generate between 5 and 15 fish
       int numFish = r.nextInt(10) + 5;
       for (int fishIdx = 0;  fishIdx < numFish; fishIdx++ ) {
    	   g.setColor(fishColors[r.nextInt(fishColors.length)]);
    	   g.fillPolygon(getFishCoords(r.nextInt(1500), r.nextInt(1500)));
       }
       
       
      //Draw Shark's Shadow
	    int[] sharkShadowCoords =  {50,600,200,700,425,625,350,500,500,
	    		575,600,650,750,700,825,775,950,765,900,900,
	    		850,910,750,875,750,875,750,950,800,1000,
	    		550,1010,425,1000,375,950,200,900,50,800,
	    		50,750,100,750,40,650};
	    sharkShadowCoords = translateCoords(sharkShadowCoords, 200, 100);
	    sharkShadowCoords = translateCoords(sharkShadowCoords, -10, -10);
	    Polygon sharkShadow = new Polygon(getXPts(sharkShadowCoords), getYPts(sharkShadowCoords), sharkShadowCoords.length / 2  );
	    g.setColor(Color.black);
	    g.fillPolygon(sharkShadow);
	    
	    
	    //Draw Shark's Body
	    int[] sharkBodyCoords = {50,600,200,700,425,625,350,500,500,
	    		575,600,650,750,700,825,775,950,765,900,900,
	    		850,910,750,875,750,875,750,950,800,1000,
	    		550,1010,425,1000,375,950,200,900,50,800,
	    		50,750,100,750,40,650};
	    //translate the shark up and to the left
	    sharkBodyCoords = translateCoords(sharkBodyCoords, 200, 100);
	    //create shark body polygon
	    Polygon sharkBody = new Polygon(getXPts(sharkBodyCoords), getYPts(sharkBodyCoords), sharkBodyCoords.length/2);
          
	    //draw shark body on canvas
	    g.setColor(Color.blue);
	    g.fillPolygon(sharkBody);
	    
	    
	    
	    
	    //Draw Shark's Belly
	    int[] sharkBellyCoords = {650,900,725,1005,550,1010,425,1000,200,900,
	    		350,850,400,875,500,875,600,925};
	    sharkBellyCoords = translateCoords(sharkBellyCoords, 200, 100);
	    Polygon sharkBelly = new Polygon(getXPts(sharkBellyCoords), getYPts(sharkBellyCoords), sharkBellyCoords.length/2);
	    g.setColor(Color.gray);
	    g.fillPolygon(sharkBelly);
	    
	    
	    //Draw Shark's Eye
	    int[] sharkEyeCoords = {700,725,825,800,700,810,600,700};
	    sharkEyeCoords = translateCoords(sharkEyeCoords, 200, 100);
	    Polygon sharkEye = new Polygon(getXPts(sharkEyeCoords), getYPts(sharkEyeCoords), sharkEyeCoords.length/2);
	    g.setColor(Color.red);
	    g.drawPolygon(sharkEye);
	    g.setColor(Color.red);
	    g.fillPolygon(sharkEye);
	    
	    //Draw Shark's Pupil and Light Reflecting off of it
	    g.setColor(Color.black);
	    g.fillOval(700 + 200 , 750 - 200,50,50);
	    g.setColor(Color.white);
	    g.fillOval(725 + 200 , 755 - 200, 25, 25);
	    
	    //Draw Shark Fangs
	    
	    //Draw Fang1
	    int[] sharkFang1Coords = {750,950,775,900,800,1000};
	    sharkFang1Coords = translateCoords(sharkFang1Coords, 200, 100);
	    Polygon sharkFang1 = new Polygon(getXPts(sharkFang1Coords), getYPts(sharkFang1Coords), sharkFang1Coords.length/2);
	    g.setColor(Color.red);
	    g.fillPolygon(sharkFang1);
	    
	    //Draw Fang2
	    int[] sharkFang2Coords = {875,905, 800,889, 777, 885, 800, 930};
	    sharkFang2Coords = translateCoords(sharkFang2Coords, 200, 100);
	    Polygon sharkFang2 = new Polygon(getXPts(sharkFang2Coords), getYPts(sharkFang2Coords), sharkFang2Coords.length/2);
	    g.setColor(Color.red);
	    g.fillPolygon(sharkFang2);
	    
	    
	    
	    
	    //There is a 50/50 chance that the Shark has its mouth drawn closed
	    int[] sharkClosedMouthCoords = {875,905, 800,889, 600,860, 750,950,800,1000 };
	    sharkClosedMouthCoords = translateCoords(sharkClosedMouthCoords, 200, 100);
	    Polygon sharkClosedMouth = new Polygon(getXPts(sharkClosedMouthCoords), getYPts(sharkClosedMouthCoords), sharkClosedMouthCoords.length/2);  
	    g.setColor(Color.blue);
	    
	    if (r.nextInt(2) == 0) {
	    	g.fillPolygon(sharkClosedMouth);
	    }
	    
	    
	    //Write Title Blue Demon Shark in layered, multi-colored text
	    g.setFont(new Font("stencil", Font.BOLD, 100));
        g.setColor(Color.red);
        g.drawString("Blue Demon Shark", 100, 100);
        g.setFont(new Font("stencil", Font.BOLD, 100));
        g.setColor(Color.black);
        g.drawString("Blue Demon Shark", 102, 102);
        g.setFont(new Font("stencil", Font.BOLD, 100));
        g.setColor(Color.white);
        g.drawString("Blue Demon Shark", 104, 104);
	}
	
	/***
	 * Extract the x coordinates from combined raw xy coords
	 * @param rawCoords
	 * @return
	 */
	public int[] getXPts(int[] rawCoords) {
		int[] xPoints = new int[rawCoords.length/2];
		 for (int xPIdx = 0; xPIdx < rawCoords.length; xPIdx+=2) {
	        	xPoints[xPIdx/2] = rawCoords[xPIdx];
	        	
	        }	
		 return xPoints;
	}
	
	/***
	 * Extract the y coordinates from combined raw xy coords
	 * @param rawCoords
	 * @return yPoints
	 */
	public int[] getYPts(int[] rawCoords) {
		 int[] yPoints = new int[rawCoords.length/2];
		 for (int yPIdx = 1; yPIdx < rawCoords.length; yPIdx+=2) {
	        	//Also translate up by 300 px;
	        	yPoints[yPIdx/2] = rawCoords[yPIdx] - 300;
	        }
		 return yPoints;
	}
	
	/***
	 * Move coordinates on the screen
	 * @param rawCoords
	 * @param xOffset
	 * @param yOffset
	 * @return translatedCoords
	 */
	public int[] translateCoords(int[] rawCoords, int xOffset, int yOffset) {
		int[] translatedCoords = new int[rawCoords.length];
		for (int rawIdx = 0; rawIdx < rawCoords.length; rawIdx++) {
			if (rawIdx % 2 == 0) {//this means it is an x coord
				translatedCoords[rawIdx] = rawCoords[rawIdx] + xOffset;
			} else {//otherwise translate the y coord
				translatedCoords[rawIdx] = rawCoords[rawIdx] + yOffset;
			}
		}
		return translatedCoords;
	}
	
	/***
	 * Generates a polygon object for a fish
	 * @param x upper left of tail
	 * @param y upper left of tail
	 * @return
	 */
	public Polygon getFishCoords(int x, int y) {
		//fish model of coords
		int[] rawFishCoords = {25,75,50,50,75,25,125,75,100,125,50,100,
				25,80,60,75};
		//Find x Offset
		int xOffset = x - 25;
		int yOffset = y - 75;
		rawFishCoords = translateCoords(rawFishCoords, xOffset, yOffset);
		return new Polygon(getXPts(rawFishCoords), getYPts(rawFishCoords), rawFishCoords.length/2);
	
	}
}

