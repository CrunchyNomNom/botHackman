package botHackman.map;

import botHackman.MoveDirection;

public class Position {
    private final int x;
    private final int y;

    public Position(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public Position add(int x, int y){
        return new Position(this.x+x, this.y+y);
    }
    public Position add(Position p){
        return new Position(this.x + p.getX(), this.y+p.getY());
    }

    public int getDistance(Position p) {
        return (this.x+p.getX())^2 + (this.y+p.getY())^2;
    }

    public Position move(MoveDirection d){
        switch(d){
            case UP:
                return this.add(0,-1);
            case DOWN:
                return this.add(0,1);
            case LEFT:
                return this.add(-1,0);
            case RIGHT:
                return this.add(1,0);
            default:
                return this;
        }
    }

    public boolean equals(Position p) {
        return this.x == p.getX() && this.y == p.getY();
    }


}
