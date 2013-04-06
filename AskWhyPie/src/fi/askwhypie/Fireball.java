package fi.askwhypie;

import org.newdawn.slick.Animation;
import org.newdawn.slick.Image;

public class Fireball extends Bullet {

    private static final int FRAME_DURATION = 250;

    public Fireball(float x, float y) {
        super(x, y, 0, 0);
        super.setCanHitEnemy(true);
        super.setCanHitWall(true);

        super.setCanHitPlayer(true);

        initFireball();
    }

    private void initFireball() {
        Image[] images = createImageArray("data/entity/fireball/loop", 0);
        super.setAnimation(new Animation(images, FRAME_DURATION, true), STATE_FLY);
    }
}
