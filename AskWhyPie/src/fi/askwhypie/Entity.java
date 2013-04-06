package fi.askwhypie;

import java.io.File;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.newdawn.slick.Animation;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.SpriteSheet;

public class Entity {
    public static final int UP = 0;
    public static final int DOWN = 1;
    public static final int LEFT = 2;
    public static final int RIGHT = 3;
    
    private float x, y, width, height;
    private float speed;
    private int facing;
    private int state;

    
    private ArrayList<Animation[]> animations;
    
    public Entity(float x, float y, float width, float height) {
	this.x = x;
	this.y = y;
	this.width = width;
	this.height = height;
	this.speed = 0;
	this.facing = 0;
	this.state = 0;
	
	animations = new ArrayList<Animation[]>();
    }
    
    public void setAnimation(Animation anim, int facing, int state) {
	while (animations.size() <= state)
	    animations.add(new Animation[4]);
	
    animations.get(state)[facing] = anim;
    }
    
    public Animation getAnimation() {
	return animations.get(this.state)[this.facing];
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
    
    
    
    
    
    
    
    
    public static Image[] createImageArray(String directory, float rotation) {
	File file = new File(directory);
	
	String[] fileNames = file.list();
	Image[] images = new Image[fileNames.length];
	
	for (int i=0; i<fileNames.length; ++i) {
	    try {
		images[i] = new Image(directory+"/"+fileNames[i]);
		images[i].rotate(rotation);
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
	
	for (int i=0; i<images.length; ++i) {
	    images[i] = sheet.getSprite(frames[i][0], frames[i][1]);
	    images[i].setRotation(rotation);
	}
	
	return images;
    }
}
