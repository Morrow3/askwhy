package fi.askwhypie;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Music;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.tiled.TiledMap;

public class HandleAct {

    GameContainer container;
    TiledMap image;
    Music music;

    public HandleAct(GameContainer container){
        this.container = container;
    }
    
    public void setMap(String map) throws SlickException{
        image = new TiledMap(map);
    }

    public void drawAct() {
        image.render(0, 0);
        playMusic();
    }
    public void setMusic(String musica) throws SlickException{
        music = new Music(musica);
    }
    public Music getMusic(){
        return music;
    }
    
    public void playMusic() {
        if(!music.playing())
        {
            music.play();
        }
    }
    
    public void stopMusic() {
        music.release();
    }
    
}
