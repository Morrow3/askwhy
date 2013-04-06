package fi.askwhypie;

import org.newdawn.slick.Animation;

public class Bullet extends Entity {
    
    public static final int STATE_FLY = 0,
			    STATE_HIT = 1,
			    STATE_VANISH = 2;
    
    
    public Bullet(float x, float y, float width, float height) {
	super(x, y, width, height);
    }
    
    
    
    @Override
    public Animation getAnimation() {
	Animation animation = super.getAnimation(0);
    
	for (int i=0; i<animation.getFrameCount(); ++i) {
        if(animation.getImage(i) == null) continue;
	    if (getFacing() == UP) {
		animation.getImage(i).setRotation(180);
	    } else if (getFacing() == DOWN) {
		animation.getImage(i).setRotation(0);
	    } else if (getFacing() == LEFT) {
		animation.getImage(i).setRotation(90);
	    } else if (getFacing() == RIGHT) {
		animation.getImage(i).setRotation(270);
	    } 
	}
	
	return animation; 
    }
    
    protected void setAnimation(Animation anim, int state) {
	super.setAnimation(anim, 0, state);
    }
}
