/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package fi.askwhypie;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;

/**
 *
 * @author joni
 */
public class FinaleScreen {
    private GameContainer container;
    private Graphics g;
    
   private String finaleStory = "ACT 2:\n" +
"You found THE LOST SWORD OF POWER, good!\n" +
          "Now it's time to hunt the GOLDEN PIE! It's umm... yea. Well, have \n" +
"a look at it yourself..\n" +
"\n" +
"\n" +
"!Press ENTER to gaze at the legendary Golden Pie!";
    
    public FinaleScreen(GameContainer container) throws SlickException
    {
        this.container = container;
        //this.g = g;
    }
    
    public void drawFinaleScreen(Graphics g)
    {
        g.drawString(finaleStory, 100, 100);
	
	
	try {
	    Image image = new Image("data/human parts/dildo.jpg");
	    g.drawImage(image, (container.getWidth()+image.getWidth())/2, 400);
	} catch (SlickException ex) {
	}
	
    }
}