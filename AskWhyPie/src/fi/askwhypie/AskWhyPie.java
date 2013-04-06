package fi.askwhypie;
import org.newdawn.slick.*;


public class AskWhyPie extends BasicGame
{
 
  public AskWhyPie()
  {
     super("Hello World");
  }
 
  @Override
  public void init(GameContainer gc) throws SlickException
  {
 
  }
 
  @Override
  public void update(GameContainer gc, int delta) throws SlickException
  {
 
  }
 
  @Override
  public void render(GameContainer gc, Graphics g) throws SlickException
  {
     g.drawString("Hello World", 100, 100);
  }
 
  public static void main(String[] args) throws SlickException
  {
     AppGameContainer app = new AppGameContainer(new AskWhyPie());
 
     app.setDisplayMode(800, 600, false);
     app.start();
  }
}