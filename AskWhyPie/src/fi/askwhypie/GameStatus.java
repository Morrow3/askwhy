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
    public static boolean isAct(){
        return gameState == 2;
    }
    public static boolean isCredits(){
        return gameState == 3;
    }
    
    
    
}
