package fi.askwhypie;

import org.newdawn.slick.Animation;
import org.newdawn.slick.Image;

public class Fireball extends Bullet {

    private static final int FRAME_DURATION = 250;

    public Fireball(Player player) {
        super(0, 0, 128, 128);
	super.setFacing(player.getFacing());
        super.setCanHitEnemy(true);
	super.setState(STATE_FLY);
	
        initFireball(player);
    }

    private void initFireball(Player player) {
	switch (super.getFacing()) {
	    case Entity.UP:
		setX(player.getX() + (player.getWidth() - super.getWidth()) / 2);
		setY(player.getY() + player.getHeight() / 2 - 30);
		setHitboxUp(15);
		setHitboxDown(40);
		setHitboxLeft(50);
		setHitboxRight(getWidth() - 50);
		break;
	    case Entity.DOWN:
		setX(player.getX() + (player.getWidth() - super.getWidth()) / 2);
		setY(player.getY() + player.getHeight() / 2 - 100);
		setHitboxUp(getHeight() - 15);
		setHitboxDown(getHeight() - 40);
		setHitboxLeft(50);
		setHitboxRight(getWidth() - 50);
		break;
	    case Entity.LEFT:
		setX(player.getX() + player.getWidth() / 2 - 30);
		setY(player.getY() + (player.getHeight() - super.getHeight()) / 2);
		setHitboxUp(50);
		setHitboxDown(getHeight() - 50);
		setHitboxLeft(15);
		setHitboxRight(40);
		break;
	    case Entity.RIGHT:
		setX(player.getX() + player.getWidth() / 2 - 100);
		setY(player.getY() + (player.getHeight() - super.getHeight()) / 2);
		setHitboxUp(50);
		setHitboxDown(getHeight() - 50);
		setHitboxLeft(getWidth() - 15);
		setHitboxRight(getHeight() - 40);
		break;
	}
	
	Image[] start = createImageArray("data/entity/fireball/start", 0);
        Image[] fly = createImageArray("data/entity/fireball/loop", 0);
	super.setAnimation(new Animation(start, FRAME_DURATION, true), STATE_START);
        super.setAnimation(new Animation(fly, FRAME_DURATION, true), STATE_FLY);
    }
}
