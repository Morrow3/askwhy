package fi.askwhypie;

import org.newdawn.slick.Animation; 
import org.newdawn.slick.AppGameContainer; 
import org.newdawn.slick.BasicGame; 
import org.newdawn.slick.GameContainer; 
import org.newdawn.slick.Graphics; 
import org.newdawn.slick.Image; 
import org.newdawn.slick.Input; 
import org.newdawn.slick.SlickException; 
import org.newdawn.slick.tiled.TiledMap;  
 
/**  
*  
* @author panos  
*/
public class AskWhyPie extends BasicGame
{
    Menu m;
    GameStatus gs;
 
     public AskWhyPie()
     {
         super("AskWhy game");

     }
 
     public static void main(String[] args)
     {
         try
         {
             AppGameContainer app = new AppGameContainer(new AskWhyPie());
             app.setDisplayMode(1312, 768, false);
             app.start();
         }
         catch (SlickException e)
         {
             e.printStackTrace();
         }
     }
 
     @Override
     public void init(GameContainer container) throws SlickException
     {
         gs = new GameStatus();
         m = new Menu(container , gs);
         
     }
 
     @Override
     public void update(GameContainer container, int delta) throws SlickException
     {
         
     }
     public void render(GameContainer container, Graphics g) throws SlickException
     {
         
         if (gs.isInGameMenu()){
            m.drawWholeMenu(g);
         }
         //grassMap.draw();
         //sprite.draw((int)x, (int)y);
     }
     

 
 }
