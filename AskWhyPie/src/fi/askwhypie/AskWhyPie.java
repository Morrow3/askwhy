package fi.askwhypie;

import java.util.ArrayList;
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
    ArrayList<Enemy> enemies;
    Fireball fireball;
    ListenerForKeyes listener;
    String[] maps;
    int map;
    float spawnEnemy;
    int enemyX;
    int enemyY;

    public AskWhyPie() {
        super("AskWhy game");
        listener = new ListenerForKeyes();
        maps = new String[]{"data/map/grasslevel.tmx", "data/map/level3.tmx"};
        map = 0;
        enemies = new ArrayList<Enemy>();

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
        if (GameStatus.isBeginActOne()) {
            container.getInput().addKeyListener(listener);
            if (Input.KEY_ENTER == listener.keyValue()) {
                spawnEnemy = 100;
                enemyX = 512;
                enemyY = 386;
                player = new Player(256, 256);
                player.setSpeed(0.5f);
                for (int i = 0; i < 16; i++) {
                    enemies.add(new Enemy(enemyX, enemyY));
                }
                container.getInput().removeAllKeyListeners();
                GameStatus.gameState = 2;
            }
        }
        if (GameStatus.isAct()) {
            player.move(1.5f);
            player.checkWallCollision(handleAct.getMap());
            spawnEnemy -= 0.5;
            if (spawnEnemy <= 0){
                enemies.add(new Enemy(enemyX, enemyY));
                spawnEnemy = 100;
            }

            if (fireball != null) {
                fireball.move();

                Enemy hittedEnemy = null;

                for (Enemy enemy : enemies) {
                    if (fireball.checkCollision(enemy)) {
                        fireball.hits();
                        hittedEnemy = enemy;
                        fireball.setCanHitEnemy(false);
                    }
                }
                if (hittedEnemy != null) {
                    enemies.remove(hittedEnemy);
                }
            }


            if (player.getHealth() <= 0) {
                GameStatus.gameState = 4;
            }

            if (listener.keyValue() == Input.KEY_UP || listener.keyValue() == Input.KEY_DOWN || listener.keyValue() == Input.KEY_LEFT || listener.keyValue() == Input.KEY_RIGHT) {
                player.setFacing(listener.arrowKeyValue());
            }
            if (listener.keyValue() == Input.KEY_X) {
                player.stopTime();
            }
            if (listener.keyValue() == Input.KEY_Z) {
                if (fireball == null || fireball.getState() == 2) {
                    fireball = new Fireball(player);
                }
                listener.keyPressed(666, 'i');
            }
            if (listener.keyValue() == Input.KEY_O) {
                if (fireball != null) {
                    fireball.hits();
                }
            }
            if (listener.keyValue() == Input.KEY_Q) {
                handleAct.stopMusic(map);
                container.exit();
            }
            if (listener.keyValue() == Input.KEY_D) {
                handleAct.stopMusic(map);
                map = 1;
            }
            if (listener.keyValue() == Input.KEY_A) {
                handleAct.stopMusic(map);
                map = 0;
            }
            if (player.getStopTime()) {
                player.pausePower -= 0.7;
                if (player.pausePower <= 0) {
                    player.continueTime();
                }
            }
            if (player.pausePower < 100) {
                player.pausePower += 0.05;
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
            g.drawString(player.getHealth() + " health", 1100, 50);
            g.drawString((int) player.pausePower + " pausePower", 1100, 80);
            g.drawAnimation(player.getAnimation(), player.getX(), player.getY());

            if (fireball != null) {
                boolean success = fireball.draw(g);

//		g.drawLine(fireball.getBorderLeft(), 0, fireball.getBorderLeft(), 1000);
//		g.drawLine(fireball.getBorderRight(), 0, fireball.getBorderRight(), 1000);
//		g.drawLine(0, fireball.getBorderUp(), 1000, fireball.getBorderUp());
//		g.drawLine(0, fireball.getBorderDown(), 1000, fireball.getBorderDown());

                if (!success) {
                    fireball = null;
                }
            }
            for (Enemy e : enemies) {
                e.draw(g);

                if (!player.getStopTime()) {
                    e.setFacing();
                    e.move(2f);
                    e.checkWallCollision(handleAct.getMap());
                }
                if (e.checkCollision(player)) {
                    player.setHealth(player.getHealth() - 2);
                }


            }
        } else if (GameStatus.isCredits()) {
            Image im = new Image("data/background.jpg");
            container.getInput().addKeyListener(listener);
            im.draw(0, 0, container.getWidth(), container.getHeight());
            g.drawString("Pisteet Kurisulle hienoista efekteistä," + "\n"
                    + "Hallolle, JMorrowlle, Numppalle ja Mazalle kiitokset."
                    + "\n" + "Tää on placeholder.", 100, 100);
            if (Input.KEY_Q == listener.keyValue()) {
                GameStatus.gameState = 0;
            }
        } else if (GameStatus.isGameOver()) {
            Image im = new Image("data/background.jpg");
            Image ko = new Image("data/gameover.png");
            im.draw(0, 0, container.getWidth(), container.getHeight());
            ko.draw(0, 0, 1000, 500);
            if (Input.KEY_Q == listener.keyValue() || Input.KEY_ENTER == listener.keyValue()) {
                enemies = new ArrayList<Enemy>();
                handleAct.stopMusic(map);
                m = new Menu(container);
                GameStatus.gameState = 0;
            }


        }
    }
}
