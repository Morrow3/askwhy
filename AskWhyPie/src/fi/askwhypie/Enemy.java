package fi.askwhypie;

import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.newdawn.slick.Animation;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.SpriteSheet;

public class Enemy extends Entity {

    public static final int STATE_WALK = 0;
    public static final int STATE_DIE = 1;
    Random random;
    int turn;
    
    public Enemy(float x, float y) {
        super(x, y, 32, 64);
        
        random = new Random();
        turn = 0;
        super.setHitboxUp(super.getHeight() / 2);
        super.setHitboxDown(super.getHitboxDown()-10);
        super.setHitboxLeft(super.getHitboxLeft()+10);
        super.setHitboxRight(super.getHitboxRight()-10);
        super.setCanHitWall(true);
        super.setCanHitPlayer(true);  
        
        initEnemy();
    }

    private void initEnemy() {
        SpriteSheet sheet = null;
        try {
            sheet = new SpriteSheet("data/entity/monster/zombie.png", 32, 64);
        } catch (SlickException ex) {
            Logger.getLogger(Enemy.class.getName()).log(Level.SEVERE, null, ex);
        }

        Image[] enemyUp = new Image[]{sheet.getSprite(0, 3), sheet.getSprite(1, 3), sheet.getSprite(2, 3), sheet.getSprite(1, 3)};
        Image[] enemyDown = new Image[]{sheet.getSprite(0, 0), sheet.getSprite(1, 0), sheet.getSprite(2, 0), sheet.getSprite(1, 0)};
        Image[] enemyLeft = new Image[]{sheet.getSprite(0, 1), sheet.getSprite(1, 1), sheet.getSprite(2, 1), sheet.getSprite(1, 1)};
        Image[] enemyRight = new Image[]{sheet.getSprite(0, 2), sheet.getSprite(1, 2), sheet.getSprite(2, 2), sheet.getSprite(1, 2)};

        setAnimation(new Animation(enemyUp, 250), Enemy.UP, STATE_WALK);
        setAnimation(new Animation(enemyDown, 250), Enemy.DOWN, STATE_WALK);
        setAnimation(new Animation(enemyLeft, 250), Enemy.LEFT, STATE_WALK);
        setAnimation(new Animation(enemyRight, 250), Enemy.RIGHT, STATE_WALK);

        setAnimation(new Animation(enemyUp, 250), Enemy.UP, STATE_DIE);
        setAnimation(new Animation(enemyUp, 250), Enemy.DOWN, STATE_DIE);
        setAnimation(new Animation(enemyUp, 250), Enemy.LEFT, STATE_DIE);
        setAnimation(new Animation(enemyUp, 250), Enemy.RIGHT, STATE_DIE);
    }
    
    public void setFacing(){
        turn++;
        if(turn > 40 ){
            this.setFacing(random.nextInt(4));
            turn = 0;
        }
    }
}
