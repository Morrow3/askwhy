package fi.askwhypie;

import java.util.logging.Level;
import java.util.logging.Logger;
import org.newdawn.slick.Animation;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;

public class BlackBullet extends Bullet {
    
    public BlackBullet(float x, float y) {
	super(x, y, 16, 16);
	super.setCanHitPlayer(true);
	
	Image[] images = null;
	try {
	    images = new Image[]{new Image("data/entity/bullet/blackBullet.png")};
	} catch (SlickException ex) {
	    Logger.getLogger(BlackBullet.class.getName()).log(Level.SEVERE, null, ex);
	}
	super.setAnimation(new Animation(images, 1000, true), STATE_FLY);
    }
    
}
