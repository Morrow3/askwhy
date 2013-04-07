package fi.askwhypie;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.Input;
import org.newdawn.slick.KeyListener;
import org.newdawn.slick.SlickException;

/**
 *
 * @author joni
 */
public class Beginning {
    private GameContainer container;
    private Graphics g;
    //private GameStatus gs;
    boolean isKeyPressed = false;
    
    String beginningStory = "ACT 1:\n" +
"You wake up. You notice that you are sleeping in the strong hands of a stuffed \n" +
"polar bear. On the floor. What ever happened last night at the party you were in\n" +
"no-one knows. \n" +
"\n" +
"Oh, and you are a skeleton. WTF MAN!?\n" +
"\n" +
"The only thing you can find from the lobby is a note that says: FIND THE LOST SWORD OF POWER AND THE GOLDEN PIE!\n" +
"\n" +
"Now, my dear Skeleton, start walking..." +
            "\n" +
            "!Press ENTER to continue!";
    
    public Beginning(GameContainer container) throws SlickException
    {
        this.container = container;
        //this.g = g;
    }
    
    public void drawBeginnings(Graphics g)
    {
        g.drawString(beginningStory, 100, 100);
        
    }
}
