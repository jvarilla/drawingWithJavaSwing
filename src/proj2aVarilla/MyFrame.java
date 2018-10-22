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

public class MyFrame extends JFrame {
	private MyPanel p;
	public MyFrame() {
		super("Blue Demon Shark");
		p = new MyPanel();
		p.setLayout(new FlowLayout());
		
		setContentPane(p);
		setSize(1500, 1500);
		setVisible(true);
	}
}
