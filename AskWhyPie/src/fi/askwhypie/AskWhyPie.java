package fi.askwhypie;

import org.newdawn.slick.AppGameContainer;
import org.newdawn.slick.BasicGame;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
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
    ListenerForKeyes listener = new ListenerForKeyes();

    public AskWhyPie() {
        super("AskWhy game");

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
    }

    public void render(GameContainer container, Graphics g) throws SlickException {

        if (GameStatus.isInGameMenu()) {
            m.drawWholeMenu(g);
        } else if (GameStatus.isBeginActOne()) {
            b.drawBeginnings(g);
            container.getInput().addKeyListener(listener);
            if (Input.KEY_ENTER == listener.keyValue()) {
                player = new Player(256, 256);
                player.setSpeed(0.5f);
                GameStatus.gameState = 2;
            }
        } else if (GameStatus.isAct()) {
            handleAct.setMap("data/map/grasslevel.tmx");
            handleAct.drawAct();
            player.move(1.5f);
            g.drawAnimation(player.getAnimation(), player.getX(), player.getY());
            if (listener.keyValue() == Input.KEY_UP || listener.keyValue() == Input.KEY_DOWN ||listener.keyValue() == Input.KEY_LEFT || listener.keyValue() == Input.KEY_RIGHT )
                player.setFacing(listener.arrowKeyValue());
            if (listener.keyValue() == Input.KEY_X)
                player.stopTime();
            if (listener.keyValue() == Input.KEY_Z)
                player.fireBall();
            if (listener.keyValue() == Input.KEY_Q)
                container.exit();
            if (player.fb != null){
                g.drawAnimation(player.fb.getAnimation(), player.fb.getX(), player.fb.getY());
                player.fb.move(1f);
            }
            
        }
    }
}
