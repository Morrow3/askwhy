package fi.askwhypie;

import org.newdawn.slick.GameContainer;


public class MenuButton {
    
    public static void buttonAction(int i, GameContainer container, Menu menu) {
        switch(i) {
            case 1: 
                GameStatus.gameState=1;
                break;
            case 2: break;
            case 3: GameStatus.gameState=3;
                break;
            case 4: break;
            case 5:
                menu.stopMenuMusic();
                container.exit();
            default: break;
        }
                    
                    
    }
    
}
