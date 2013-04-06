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
public class ThirdTextScreen {
    private GameContainer container;
    private Graphics g;
    
   private String thirdStory = "ACT 3: \n" +
"Found your first bodypart did you? Nicely done!\n" +
"\n" +
"Now, the next step would be to.. well find all the rest. Pronto!\n" +
"Living with that ugly face.. ..skull.. of yours won't get you alot of pie will it?!\n" +
"\n" +
"Get walking!\n" +
"\n" +
"!Press ENTER to continue lookin!";
    
    public ThirdTextScreen(GameContainer container) throws SlickException
    {
        this.container = container;
        //this.g = g;
    }
    
    public void drawThirdTextScreen(Graphics g)
    {
        g.drawString(thirdStory, 100, 100);
        
    }
}
