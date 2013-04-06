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
public class SecondTextScreen {
    private GameContainer container;
    private Graphics g;
    
   private String secondStory = "ACT 2:\n" +
"You get out of Klusteri. You are now faced with serious challenges. You must \n" +
"find your bodyparts that are scattered all over the place. You can't stop walking.\n" +
"Only when you've found all of the parts you might find the mysterious GOLDEN PIE...\n" +
"\n" +
"!Press ENTER to continue walking...!";
    
    public SecondTextScreen(GameContainer container) throws SlickException
    {
        this.container = container;
        //this.g = g;
    }
    
    public void drawSecondTextScreen(Graphics g)
    {
        g.drawString(secondStory, 100, 100);
        
    }
}
