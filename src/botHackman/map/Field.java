package botHackman.map;

import java.util.ArrayList;

public class Field {
    final Map map;
    final Position position;
    private boolean accesible;
    private ArrayList<Move> validMoves;

    public Field(Map map, Position p){
        this.map = map;
        this.position = p;
        this.accesible = false;
        this.validMoves = new ArrayList<>();
    }

    public void setAccesible() {
        this.accesible = true;
    }

    public boolean isAccesible() {
        return accesible;
    }

    public void addValidMoves(Move m){
        this.validMoves.add(m);
    }

    public ArrayList<Move> getValidMoves() {
        return validMoves;
    }
}
