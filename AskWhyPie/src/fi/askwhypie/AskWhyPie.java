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
    Beginning b;
    
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
         m = new Menu(container);
         b = new Beginning(container);
     }
 
     @Override
     public void update(GameContainer container, int delta) throws SlickException
     {
         
     }
     public void render(GameContainer container, Graphics g) throws SlickException
     {
         
         if (GameStatus.isInGameMenu()){
            m.drawWholeMenu(g);
         } else if (GameStatus.isBeginActOne()) {
             b.drawBeginnings(g);
             MenuListener ml = new MenuListener(container);
             int i = Input.KEY_ENTER;
             g.drawString(i+"", 100, 300);
             //GameStatus.gameState++;
         } else if (GameStatus.isActOne()){
             
         }
     }
     

 
 }
