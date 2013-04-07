package fi.askwhypie;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.tiled.TiledMap;

public class HandleAct {

    GameContainer container;
    TiledMap image;

    public HandleAct(GameContainer container){
        this.container = container;
    }
    
    public void setMap(String map) throws SlickException{
        image = new TiledMap(map);
    }

    public void drawAct() {
        image.render(0, 0);
    }
    
    public TiledMap getMap() {
	return image;
    }
}
