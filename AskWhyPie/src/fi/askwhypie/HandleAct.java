package fi.askwhypie;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Music;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.tiled.TiledMap;

public class HandleAct {

    GameContainer container;
    TiledMap image;
    Music[] musics;

    public HandleAct(GameContainer container) throws SlickException{
        this.container = container;
        musics = new Music[]{new Music("data/music/toka.wav"), new Music("data/music/kolmas.wav")};
    }
    
    public void setMap(String map) throws SlickException{
        image = new TiledMap(map);
    }

    public void drawAct(int i) {
        image.render(0, 0);
        playMusic(i);
    }
<<<<<<< HEAD
    
    public TiledMap getMap() {
	return image;
    }
=======
   
    public void playMusic(int i) {
        if(!musics[i].playing())
        {
            musics[i].play();
        }
    }
    
    public void stopMusic(int i) {
        if(musics[i].playing()){
            musics[i].stop();
            
        }
    }
    
>>>>>>> 69e875d3a9bac4a035328c0845c80a2be2f1cd6c
}
