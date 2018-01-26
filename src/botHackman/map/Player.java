package botHackman.map;

public class Player {
    final Map map;
    final Position position;
    final int playerID;
    int snippets;
    int bombs;

    public Player(Map map, Position p, int id) {
        this.map = map;
        this.position = p;
        this.playerID = id;
        this.snippets = 0;
        this.bombs = 0;
    }

    public int getPlayerID() {
        return playerID;
    }

    public Position getPosition() {
        return position;
    }
}
