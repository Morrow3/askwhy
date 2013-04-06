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
public class Menu {
    private GameContainer gc;
    private Graphics g;
    private Image background;
    private Image newgame;
    private Image loadgame;
    private Image quit;
    private Image credits;
    private Image options;
    

    public Menu(GameContainer gc, Graphics g) {
        this.gc = gc;
        this.g = g;
    }
    
    public void drawMenu() throws SlickException
    {
        background = new Image("background.jpg");
        background.draw(0, 0, gc.getWidth(), gc.getHeight());
    }
    
    public void drawButtonNewGame() throws SlickException
    {
        newgame = new Image("newgame.jpg");
        newgame.draw(300, 100, 100, 50);
    }
    
    public void drawButtonLoadGame() throws SlickException
    {
        loadgame = new Image("loadgame.jpg");
        loadgame.draw(300, 200, 100, 50);
    }
    
    public void drawButtonCredits() throws SlickException
    {
        credits = new Image("credits.jpg");
        credits.draw(300, 300, 100, 50);
        //
    }
}