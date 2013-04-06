package fi.askwhypie;

import org.newdawn.slick.Input;
import org.newdawn.slick.KeyListener;

public class ListenerForKeyes implements KeyListener {

    private int key = 0;

    public int keyValue() {
        return key;
    }

    public int arrowKeyValue() {
        switch (key) {
            case Input.KEY_UP:
                return Entity.UP;
            case Input.KEY_DOWN:
                return Entity.DOWN;
            case Input.KEY_LEFT:
                return Entity.LEFT;
            case Input.KEY_RIGHT:
                return Entity.RIGHT;
        }
        return 0;
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
