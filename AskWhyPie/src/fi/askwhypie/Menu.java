/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package fi.askwhypie;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.Input;
import org.newdawn.slick.Music;
import org.newdawn.slick.SlickException;

/**
 *
 * @author joni
 */
public class Menu {
    private GameContainer container;
    private Image background;
    private Image newgame;
    private Image loadgame;
    private Image quit;
    private Image credits;
    private Image options;
    private MenuListener ml;
    private Music menuMusic;
        
    
    

    public Menu(GameContainer container) throws SlickException {
        this.container = container;
        ml = new MenuListener(container);
        container.getInput().addKeyListener(ml);
        newgame = new Image("data/newgamev1.png");
        loadgame = new Image("data/loadgamev1.png");
        quit = new Image("data/exitv1.png");
        credits = new Image("data/creditsv1.png");
        options = new Image("data/optionsv1.png");
        menuMusic = new Music("data/music/eka.wav");
    }
    
    public void drawMenu() throws SlickException
    {
        background = new Image("data/background.jpg");
        background.draw(0, 0, container.getWidth(), container.getHeight());
    }
    
    
    public void drawButton(Image image , int x , int y , boolean big){
        if (big){
            image.draw(x, y, 350 , 150);
        } else {
            image.draw(x, y, 250 , 100);
        }
    }
    
    public void drawWholeMenu(Graphics g) throws SlickException
    {
        
        drawMenu();
        for (int i = 1; i < 6; i++) {
            if (ml.getSelected() == i){
                drawButton(getImage(i), 700, i* 100, true);
            } else {
                drawButton(getImage(i), 700, i * 100, false);
            }
            g.drawString(ml.getSelected() + "", 100, 100);
        }
    }
    
    public void playMenuMusic() {
        if(!menuMusic.playing())
        {
            menuMusic.play();
        }
    }
    
    private Image getImage(int i){
        if (i == 1){
            return newgame;
        }
        if (i == 2){
            return loadgame;
        }
        if (i == 3){
            return credits;
        }
        if (i == 4){
            return options;
        }
        if (i == 5){
            return quit;
        }
        return null;
    }
}