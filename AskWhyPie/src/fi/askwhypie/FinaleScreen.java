/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package fi.askwhypie;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.SlickException;

/**
 *
 * @author joni
 */
public class FinaleScreen {
    private GameContainer container;
    private Graphics g;
    
   private String finaleStory = "ACT 5:\n" +
"There it is! The great Golden Pie! And it's.. it's umm... yea. Well, have \n" +
"a look at it yourself..\n" +
"\n" +
"Thanks for playing, sucker!\n" +
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
        
    }
}