package fi.askwhypie;

import org.newdawn.slick.Input;
import org.newdawn.slick.KeyListener;

public class ListenerForKeyes implements KeyListener{
    private int key = 0;
    
    public int keyValue(){
        return key;
    }
    @Override
    public void keyPressed(int i, char c) {
        key = i;
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
    
}
