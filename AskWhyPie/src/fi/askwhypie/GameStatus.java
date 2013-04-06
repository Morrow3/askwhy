package fi.askwhypie;

public class GameStatus {
    private static boolean inGameMenu;
    private static boolean inBeginnings;
    static {
        inGameMenu = true;
    }
    public static void newGame(){
        inGameMenu = false;
        inBeginnings = true;
    }

    public static boolean isInGameMenu() {
        return inGameMenu;
    }
    
    public static boolean isInBeginnings() {
        return inBeginnings;
    }
    
    
    
}
