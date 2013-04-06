package fi.askwhypie;

import org.newdawn.slick.Animation;

public class Entity {
    public static final int UP = 0;
    public static final int DOWN = 1;
    public static final int LEFT = 2;
    public static final int RIGHT = 3;
    
    private float x;
    private float y;
    private float speed;
    private int facing;
    
    private Animation[] animation= new Animation[4];
    
    
    public Entity(float x, float y) {
	this.x = x;
	this.y = y;
	this.speed = 0;
	this.facing = 0;
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
    
    public Animation getAnimation(int facing) {
	return animation[facing];
    }
    
    public void setAnimation(Animation anim, int facing) {
	this.animation[facing] = anim;
    }
}
