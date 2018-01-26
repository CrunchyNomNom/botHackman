package botHackman.engine;

public class State {

    private int MAX_TIMEBANK;
    private int MAX_MOVE_TIME;
    private int MAX_ROUNDS;
    private int BOARD_WIDHT;
    private int BOARD_HEIGHT;

    private int currentRound;
    private int timebank;
    private String[] boardUpdate;

    private int playerSnippets;
    private int playerBombs;
    private int playerID;
    private String playerName;

    private int enemySnippets;
    private int enemyBombs;
    private int enemyID;
    private String enemyName;

    public State() {
        this.playerBombs = 0;
        this.playerSnippets = 0;
        this.enemyBombs = 0;
        this.enemySnippets = 0;
    }

    void setMAX_TIMEBANK(int x) { this.MAX_TIMEBANK = x; }
    void setMAX_MOVE_TIME(int x) { this.MAX_MOVE_TIME = x; }
    void setMAX_ROUNDS(int x) { this.MAX_ROUNDS = x; }
    void setBOARD_WIDHT(int x) { this.BOARD_WIDHT = x; }
    void setBOARD_HEIGHT(int x) { this.BOARD_HEIGHT = x; }

    void setCurrentRound(int x) { this.currentRound = x; }
    void setTimebank(int x) { this.timebank = x; }
    void setBoardUpdate(String x) { this.boardUpdate = x.split(","); }

    void setPlayerSnippets(int x) { this.playerSnippets = x; }
    void setPlayerBombs(int x) { this.playerBombs = x; }
    void setPlayerID(int x) { this.playerID = x; }
    void setPlayerName(String x) { this.playerName = x; }

    void setEnemySnippets(int x) { this.enemySnippets = x; }
    void setEnemyBombs(int x) { this.enemyBombs = x; }
    void setEnemyID(int x) { this.enemyID = x; }
    void setEnemyName(String x) { this.enemyName = x; }

    public int getMAX_TIMEBANK() {
        return MAX_TIMEBANK;
    }

    public int getMAX_MOVE_TIME() {
        return MAX_MOVE_TIME;
    }

    public int getMAX_ROUNDS() {
        return MAX_ROUNDS;
    }

    public int getBOARD_WIDHT() {
        return BOARD_WIDHT;
    }

    public int getBOARD_HEIGHT() {
        return BOARD_HEIGHT;
    }

    public int getCurrentRound() {
        return currentRound;
    }

    public int getTimebank() {
        return timebank;
    }

    public String[] getBoardUpdate() {
        return boardUpdate;
    }

    public int getPlayerSnippets() {
        return playerSnippets;
    }

    public int getPlayerBombs() {
        return playerBombs;
    }

    public int getPlayerID() {
        return playerID;
    }

    public String getPlayerName() {
        return playerName;
    }

    public int getEnemySnippets() {
        return enemySnippets;
    }

    public int getEnemyBombs() {
        return enemyBombs;
    }

    public int getEnemyID() {
        return enemyID;
    }

    public String getEnemyName() {
        return enemyName;
    }
}
