package fi.askwhypie;

public class GameStatus {
    private static boolean inGameMenu;
    static {
        inGameMenu = true;
    }
    public static void newGame(){
        inGameMenu = false;
    }

    public static boolean isInGameMenu() {
        return inGameMenu;
    }
    
    
    
}
