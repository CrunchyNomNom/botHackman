package botHackman.map;

import botHackman.engine.State;
import botHackman.map.Snippet;
import botHackman.map.Player;
import botHackman.map.Position;
import botHackman.map.Field;

import java.util.ArrayList;

public class Map {
    private State state;
    private MapParser mp;

    private int width;
    private int height;

    Field[][] board;
    ArrayList<Player> players;
    ArrayList<Snippet> snippets;

    public Map(State state) {
        this.state = state;
        this.mp = new MapParser(this);
    }
    public void start(){
        this.width = state.getBOARD_WIDHT();
        this.height = state.getBOARD_HEIGHT();
        this.board = new Field[width][height];
        for(int i = 0; i < width * height; i++){
            int x = i%width;
            int y = i / width;
            this.board[x][y] = new Field(this, new Position(x,y));
        }
        String[] s = state.getBoardUpdate();
        mp.startBoard(s);
        this.players = new ArrayList<>();
        this.snippets = new ArrayList<>();
        mp.updateObjects(s);
    }

    public ArrayList<Player> getPlayers() {
        return players;
    }

    public ArrayList<Snippet> getSnippets() {
        return snippets;
    }

    public Field[][] getBoard() {
        return board;
    }

    public int getHeight() {
        return height;
    }

    public int getWidth() {
        return width;
    }

    public ArrayList<Move> getValidMoves(Position p){
        return board[p.getX()][p.getY()].getValidMoves();
    }

    public Player getPlayer() {
        for(Player player : players)
            if(player.getPlayerID() == state.getPlayerID()) return player;
        return null;
    }

    public boolean isAccessible(Position p){
        return isInsideMap(p) && board[p.getX()][p.getY()].isAccesible();
    }

    public boolean isInsideMap(Position p) {
        return p.getX() >= 0 && p.getX() < this.width && p.getY() >= 0 && p.getY() < this.height;
    }

    public void update(){
        mp.updateObjects(state.getBoardUpdate());
    }

    public void setPlayers(ArrayList<Player> players) {
        this.players = players;
    }

    public void setSnippets(ArrayList<Snippet> snippets) {
        this.snippets = snippets;
    }
}
