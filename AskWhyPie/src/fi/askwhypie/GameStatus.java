package fi.askwhypie;

public class GameStatus {
    public static int gameState;
    
    static {
        gameState = 0;
    }

    public static boolean isInGameMenu() {
        return gameState == 0;
    }
    public static boolean isBeginActOne(){
        return gameState == 1;
    }
    public static boolean isActOne(){
        return gameState == 2;
    }
    
    
    
}
