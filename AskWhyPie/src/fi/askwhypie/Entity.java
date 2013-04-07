package fi.askwhypie;

import java.io.File;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.newdawn.slick.Animation;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.SpriteSheet;
import org.newdawn.slick.tiled.TiledMap;

public class Entity {

    public static final int UP = 0;
    public static final int DOWN = 1;
    public static final int LEFT = 2;
    public static final int RIGHT = 3;
    private ArrayList<Animation[]> animations;
    private float x, y, width, height;
    private float speed;
    private int facing;
    private int state;
    private int health;
    private float hitboxUp,
            hitboxDown,
            hitboxLeft,
            hitboxRight;
    private boolean canHitPlayer,
            canHitEnemy,
            canHitWall;

    public Entity(float x, float y, float width, float height) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        this.speed = 0;
        this.facing = 0;
        this.health = 100;
        this.state = 0;
        this.hitboxUp = 0;
        this.hitboxDown = height;
        this.hitboxLeft = 0;
        this.hitboxRight = width;
        this.canHitPlayer = false;
        this.canHitEnemy = false;
        this.canHitWall = false;

        animations = new ArrayList<Animation[]>();
    }
    
    public void draw(Graphics g) {
	g.drawAnimation(getAnimation(), x, y);
    }
    
    public void setAnimation(Animation anim, int facing, int state) {
        while (animations.size() <= state) {
            animations.add(new Animation[4]);
        }

        animations.get(state)[facing] = anim;
    }

    public Animation getAnimation() {
        return animations.get(this.state)[facing];
    }

    public Animation getAnimation(int facing) {
        return animations.get(this.state)[facing];
    }

    public Animation getAnimation(int facing, int state) {
        return animations.get(state)[facing];
    }

    public float getX() {
        return x;
    }

    public void setX(float x) {
        this.x = x;
    }

    public void moveX() {
        moveX(speed);
    }

    public void moveX(float x) {
        this.x += x;
    }

    public float getY() {
        return y;
    }

    public void setY(float y) {
        this.y = y;
    }

    public void moveY() {
        moveY(speed);
    }

    public void moveY(float y) {
        this.y += y;
    }

    public void move() {
        move(speed);
    }

    public void move(float speed) {
        switch (facing) {
            case UP:
                moveY(-speed);
                break;
            case DOWN:
                moveY(speed);
                break;
            case LEFT:
                moveX(-speed);
                break;
            case RIGHT:
                moveX(speed);
                break;
        }
    }

    public float getHeight() {
        return height;
    }

    public void setHeight(float height) {
        this.height = height;
    }

    public float getWidth() {
        return width;
    }

    public void setWidth(float width) {
        this.width = width;
    }

    public float getSpeed() {
        return speed;
    }

    public void setSpeed(float speed) {
        this.speed = speed;
    }

    public int getFacing() {
        return facing;
    }

    public void setFacing(int facing) {
        this.facing = facing;
    }

    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
    }

    public float getHitboxDown() {
        return hitboxDown;
    }

    public void setHitboxDown(float hitboxDown) {
        this.hitboxDown = hitboxDown;
    }

    public float getHitboxLeft() {
        return hitboxLeft;
    }

    public void setHitboxLeft(float hitboxLeft) {
        this.hitboxLeft = hitboxLeft;
    }

    public float getHitboxRight() {
        return hitboxRight;
    }

    public void setHitboxRight(float hitboxRight) {
        this.hitboxRight = hitboxRight;
    }

    public float getHitboxUp() {
        return hitboxUp;
    }

    public void setHitboxUp(float hitboxUp) {
        this.hitboxUp = hitboxUp;
    }

    public float getBorderUp() {
        return y + hitboxUp;
    }

    public float getBorderDown() {
        return y + hitboxDown;
    }

    public float getBorderLeft() {
        return x + hitboxLeft;
    }

    public float getBorderRight() {
        return x + hitboxRight;
    }

    public boolean isCanHitEnemy() {
        return canHitEnemy;
    }

    public void setCanHitEnemy(boolean canHitEnemy) {
        this.canHitEnemy = canHitEnemy;
    }

    public boolean isCanHitPlayer() {
        return canHitPlayer;
    }

    public void setCanHitPlayer(boolean canHitPlayer) {
        this.canHitPlayer = canHitPlayer;
    }

    public boolean isCanHitWall() {
        return canHitWall;
    }

    public void setCanHitWall(boolean canHitWall) {
        this.canHitWall = canHitWall;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public int getHealth() {
        return health;
    }

    public boolean checkCollision(Entity entity) {
        if (!this.canHitPlayer && entity instanceof Player) {
            return false;
        } else if (!this.canHitEnemy && entity instanceof Enemy) {
            return false;
        }

        float up1 = this.getBorderUp();
        float down1 = this.getBorderDown();
        float left1 = this.getBorderLeft();
        float right1 = this.getBorderRight();

        float up2 = entity.getBorderUp();
        float down2 = entity.getBorderDown();
        float left2 = entity.getBorderLeft();
        float right2 = entity.getBorderRight();


        if ((up1 < up2 && up2 < down1) || (up2 < up1 && up1 < down2)) {
            //    System.out.println("jous");
            if ((left1 < left2 && left2 < right1) || (left2 < left1 && left1 < right2)) {
                return true;
            }
        }
        return false;
    }
    
    public void checkWallCollision(TiledMap tiledMap) {
	if (canHitWall) {
	    //Ruudun reunojen tarkistus
	    if (getBorderLeft() < 0)
		x = 0 - getHitboxLeft();
	    if (getBorderRight() > 1024)
		x = 1024 - getHitboxRight();
	    if (getBorderUp() < 15)
		y = 15 - getHitboxUp();
	    if (getBorderDown() > 768)
		y = 768 - getHitboxDown();
	    
	    
	    boolean[][] map = createWallMap(tiledMap);
	    
	    if (map == null)
		return;
	    
	    int up = (int)getBorderUp() / 32;
	    int down = (int)((getBorderDown()-1) / 32);
	    int left = (int)(getBorderLeft()) / 32;
	    int right = (int)(getBorderRight()-1) / 32;
	    
	    if (facing == UP) {
		if (map[left][up] || map[right][up])
		    y = up * 32;
	    } else if (facing == DOWN) {
		if (map[left][down] || map[right][down])
		    y = down * 32 - getHitboxDown();
	    } else if (facing == LEFT) {
		if (map[left][up] || map[left][down])
		    x = left * 32 + width - getHitboxLeft();
	    } else if (facing == RIGHT) {
		if (map[right][up] || map[right][down])
		    x = right * 32 - width + (width - getHitboxRight());
	    }
	}
	
    }
    
    
    public boolean[][] createWallMap(TiledMap map) {
	if (map == null)
	    return null;
	
	int layer = map.getLayerIndex("Tile Layer 3");
	boolean[][] wallMap = new boolean[32][24];
	
	for (int j=0; j<wallMap[0].length; ++j)
	    for (int i=0; i<wallMap.length; ++i)
		if (map.getTileId(i, j, layer) != 0)
		    wallMap[i][j] = true;
	
	return wallMap;
    }

    public static Image[] createImageArray(String directory, float rotation) {
        File file = new File(directory);

        String[] fileNames = file.list();
        Image[] images = new Image[fileNames.length];

        for (int i = 0; i < fileNames.length; ++i) {
            try {
                if(fileNames[i].contains(".png")){
                images[i] = new Image(directory + "/" + fileNames[i]);
                images[i].rotate(rotation);
                }
            } catch (SlickException ex) {
                Logger.getLogger(AskWhyPie.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

        return images;
    }

    public static Image[] createImageArray(SpriteSheet sheet, int[][] frames, float rotation) {
        /* Esimerkki miten voi käyttää tätä metodia
         Image[] playerUp    = createImageArray(sheet, new int[][]{{0, 3}, {1, 3}, {2, 3}, {1, 3}}, 0);
         Image[] playerDown  = createImageArray(sheet, new int[][]{{0, 0}, {1, 0}, {2, 0}, {1, 0}}, 0);
         Image[] playerLeft  = createImageArray(sheet, new int[][]{{0, 1}, {1, 1}, {2, 1}, {1, 1}}, 0);
         Image[] playerRight = createImageArray(sheet, new int[][]{{0, 2}, {1, 2}, {2, 2}, {1, 2}}, 0);
         */

        Image[] images = new Image[frames[0].length];

        for (int i = 0; i < images.length; ++i) {
            images[i] = sheet.getSprite(frames[i][0], frames[i][1]);
            images[i].setRotation(rotation);
        }

        return images;
    }
}
