package fi.askwhypie;

import org.newdawn.slick.Animation;
import org.newdawn.slick.Image;

public class Fireball extends Bullet {
    
    private static final int FRAME_DURATION = 250;
    
    
    public Fireball(float x, float y, float width, float height) {
	super(x, y, width, height);
	initFireball();
    }
    
    private void initFireball() {
	Image[] images = createImageArray("data/fireball/loop", 0);
	
	super.setAnimation(new Animation(images, FRAME_DURATION, true), STATE_FLY);
    }
}
