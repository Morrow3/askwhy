package fi.askwhypie;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Input;
import org.newdawn.slick.KeyListener;

public class MenuListener implements KeyListener{
    private int selection;
    private GameContainer container;
    
    public MenuListener(GameContainer container) {
        this.container=container;
        selection = 1;
    }
    
    

    @Override
    public void keyPressed(int i, char c) {
        if (i == Input.KEY_DOWN){
            selection++;
        } else if (i == Input.KEY_UP){
            selection--;
        }

        if (selection < 1){
            selection = 5;
        } else if (selection > 5){
            selection = 1;
        }
        
    }

    @Override
    public void keyReleased(int i, char c) {
    }

    @Override
    public void setInput(Input input) {
    }

    @Override
    public boolean isAcceptingInput() {
        return true;
    }

    @Override
    public void inputEnded() {
    }

    @Override
    public void inputStarted() {
    }
    
    public int getSelected()
    {
        return selection;
    }
    
}
