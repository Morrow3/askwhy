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
public class FourthTextScreen {
    private GameContainer container;
    private Graphics g;
    
   private String fourthStory = "ACT 4:\n" +
"You've found most of the parts you lost last night but one is still to be found.\n" +
"Where is it? No, really! Where the hell is it?\n" +
"\n" +
"KEEP LOOKING FUKSI!\n" +
"\n" +
"!Press ENTER to continue!";
    
    public FourthTextScreen(GameContainer container) throws SlickException
    {
        this.container = container;
        //this.g = g;
    }
    
    public void drawFourthTextScreen(Graphics g)
    {
        g.drawString(fourthStory, 100, 100);
        
    }
}

