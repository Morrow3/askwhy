/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package fi.askwhypie;

/**
 *
 * @author joni
 */
public class Enemy extends Entity {
    
    private float x;
    private float y;
    private float speed;
    private int facing;
    
    public Enemy(float x, float y) {
	super(x,y);
        this.speed = 0;
	this.facing = 0;
    }
    
}
