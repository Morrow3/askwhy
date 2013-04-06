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
     private Image grassMap;
     private Animation sprite, up, down, left, right;
     private float x = 34f, y = 34f;
 
     /** The collision map indicating which tiles block movement - generated based on tile properties */
     private static final int SIZE = 34;
 
     public AskWhyPie()
     {
         super("AskWhy game");
     }
 
     public static void main(String [] arguments)
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
         Image [] movementUp = {new Image("data/dude.png"), new Image("data/dude.png")};
         Image [] movementDown = {new Image("data/dude.png"), new Image("data/dude.png")};
         Image [] movementLeft = {new Image("data/dude.png"), new Image("data/dude.png")};
         Image [] movementRight = {new Image("data/dude.png"), new Image("data/dude.png")};
         int [] duration = {300, 300};         
         grassMap = new Image("data/map.jpg");
 
          /*
          * false variable means do not auto update the animation.
          * By setting it to false animation will update only when
          * the user presses a key.
          */
         up = new Animation(movementUp, duration, false);
         down = new Animation(movementDown, duration, false);
         left = new Animation(movementLeft, duration, false);
         right = new Animation(movementRight, duration, false);
 
         // Original orientation of the sprite. It will look right.
         sprite = right;
 
         // build a collision map based on tile properties in the TileD map
         
     }
 
     @Override
     public void update(GameContainer container, int delta) throws SlickException
     {
         Input input = container.getInput();
         if (input.isKeyDown(Input.KEY_UP))
         {
             sprite = up;
             y-=1;
             
         }
         else if (input.isKeyDown(Input.KEY_DOWN))
         {
             sprite = down;
             y+=1;
             
         }
         else if (input.isKeyDown(Input.KEY_LEFT))
         {
             sprite = left;
             x-=1;
             
         }
         else if (input.isKeyDown(Input.KEY_RIGHT))
         {
             sprite = right;
             x+=1;
             
         }
     }
 
     public void render(GameContainer container, Graphics g) throws SlickException
     {
         grassMap.draw();
         sprite.draw((int)x, (int)y);
     }
 
 }
