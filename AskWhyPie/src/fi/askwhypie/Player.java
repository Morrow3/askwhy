package fi.askwhypie;

import java.util.logging.Level;
import java.util.logging.Logger;
import org.newdawn.slick.Animation;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.SpriteSheet;

public class Player extends Entity {
    
    public static final int STATE_WALK = 0;
    public static final int STATE_DIE = 1;
    
    
    public Player(float x, float y) {
	super(x, y, 32, 64);
	super.setHitboxUp(super.getHeight() / 2);
	super.setCanHitWall(true);
	
	initPlayer();
    }
    
    private void initPlayer() {
	SpriteSheet sheet = null;
	try {
	    sheet = new SpriteSheet("data/entity/player/skeleton.png", 32, 64);
	} catch (SlickException ex) {
	    Logger.getLogger(Player.class.getName()).log(Level.SEVERE, null, ex);
	}

	Image[] playerUp    = new Image[]{sheet.getSprite(0, 3), sheet.getSprite(1, 3), sheet.getSprite(2, 3), sheet.getSprite(1, 3)};
	Image[] playerDown  = new Image[]{sheet.getSprite(0, 0), sheet.getSprite(1, 0), sheet.getSprite(2, 0), sheet.getSprite(1, 0)};
	Image[] playerLeft  = new Image[]{sheet.getSprite(0, 1), sheet.getSprite(1, 1), sheet.getSprite(2, 1), sheet.getSprite(1, 1)};
	Image[] playerRight = new Image[]{sheet.getSprite(0, 2), sheet.getSprite(1, 2), sheet.getSprite(2, 2), sheet.getSprite(1, 2)};

	setAnimation(new Animation(playerUp, 250), Player.UP, STATE_WALK);
	setAnimation(new Animation(playerDown, 250), Player.DOWN, STATE_WALK);
	setAnimation(new Animation(playerLeft, 250), Player.LEFT, STATE_WALK);
	setAnimation(new Animation(playerRight, 250), Player.RIGHT, STATE_WALK);
	
	setAnimation(new Animation(playerUp, 250), Player.UP, STATE_DIE);
	setAnimation(new Animation(playerUp, 250), Player.DOWN, STATE_DIE);
	setAnimation(new Animation(playerUp, 250), Player.LEFT, STATE_DIE);
	setAnimation(new Animation(playerUp, 250), Player.RIGHT, STATE_DIE);
    }
    
    

}
