package fi.askwhypie;

import org.newdawn.slick.GameContainer;


public class MenuButton {
    
    public static void buttonAction(int i, GameContainer container , GameStatus gs) {
        switch(i) {
            case 1: gs.newGame();
            case 2: break;
            case 3: break;
            case 4: break;
            case 5: container.exit();
            default: break;
        }
                    
                    
    }
    
}
