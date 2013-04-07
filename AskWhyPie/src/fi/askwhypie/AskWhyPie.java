package fi.askwhypie;

import org.newdawn.slick.AppGameContainer;
import org.newdawn.slick.BasicGame;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.Input;
import org.newdawn.slick.SlickException;

/**
 *
 * @author panos
 */
public class AskWhyPie extends BasicGame {

    Menu m;
    Beginning b;
    HandleAct handleAct;
    Player player;
    Fireball fireball;
    ListenerForKeyes listener;
    String[] maps;
    int map;

    public AskWhyPie() {
        super("AskWhy game");
        listener = new ListenerForKeyes();
        maps = new String[]{"data/map/grasslevel.tmx", "data/map/level3.tmx"};
        map = 0;

    }

    public static void main(String[] args) {
        try {
            AppGameContainer app = new AppGameContainer(new AskWhyPie());
            app.setDisplayMode(1312, 768, false);
            app.start();
        } catch (SlickException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void init(GameContainer container) throws SlickException {
        m = new Menu(container);
        b = new Beginning(container);
        handleAct = new HandleAct(container);
    }

    @Override
    public void update(GameContainer container, int delta) throws SlickException {
        if (GameStatus.isBeginActOne()){
            container.getInput().addKeyListener(listener);
            if (Input.KEY_ENTER == listener.keyValue()) {
                player = new Player(256, 256);
                player.setSpeed(0.5f);
                container.getInput().removeAllKeyListeners();
                GameStatus.gameState = 2;
            }
        }
        if (GameStatus.isAct()){
            player.move(1.5f);
	    player.checkWallCollision(handleAct.getMap());
	    
            if (listener.keyValue() == Input.KEY_UP || listener.keyValue() == Input.KEY_DOWN ||listener.keyValue() == Input.KEY_LEFT || listener.keyValue() == Input.KEY_RIGHT )
                player.setFacing(listener.arrowKeyValue());
            if (listener.keyValue() == Input.KEY_X)
                player.stopTime();
            if (listener.keyValue() == Input.KEY_Z)
                fireball = new Fireball(player);
            if (listener.keyValue() == Input.KEY_Q)
                container.exit();
            if (listener.keyValue() == Input.KEY_D) {
                handleAct.stopMusic(map);
                map = 1;
            }
            if (listener.keyValue() == Input.KEY_A){
                handleAct.stopMusic(map);
                map = 0;
            }
        }
    }

    public void render(GameContainer container, Graphics g) throws SlickException {

        if (GameStatus.isInGameMenu()) {
            m.drawWholeMenu(g);
            m.playMenuMusic();
        } else if (GameStatus.isBeginActOne()) {
            m.stopMenuMusic();
            b.drawBeginnings(g);
        } else if (GameStatus.isAct()) {
            handleAct.setMap(maps[map]);
            handleAct.drawAct(map);
            g.drawString("Player:", 1075, 20);
            g.drawString(player.getHealth()+" health", 1100, 50 );
            g.drawAnimation(player.getAnimation(), player.getX(), player.getY());
            
            if (fireball != null){
                fireball.draw(g);
                fireball.move(5f);
		
//		g.drawLine(fireball.getBorderLeft(), 0, fireball.getBorderLeft(), 1000);
//		g.drawLine(fireball.getBorderRight(), 0, fireball.getBorderRight(), 1000);
//		g.drawLine(0, fireball.getBorderUp(), 1000, fireball.getBorderUp());
//		g.drawLine(0, fireball.getBorderDown(), 1000, fireball.getBorderDown());
            }
        } else if (GameStatus.isCredits()) {
            Image im = new Image("data/background.jpg");
            container.getInput().addKeyListener(listener);
            im.draw(0, 0, container.getWidth(), container.getHeight());
            g.drawString("Pisteet Kurisulle hienoista efekteistä," + "\n" +
                    "Hallolle, JMorrowlle, Numppalle ja Mazalle kiitokset." +
                    "\n" + "Tää on placeholder.", 100, 100);
            if (Input.KEY_Q == listener.keyValue()) {
                GameStatus.gameState = 0;
            }
        }
	
	
    }
}
