package fi.askwhypie;

public class GameStatus {
    private boolean inGameMenu;
    
    public GameStatus(){
        this.inGameMenu = true;
    }
    
    public void newGame(){
        inGameMenu = false;
    }

    public boolean isInGameMenu() {
        return inGameMenu;
    }
    
    
    
}
