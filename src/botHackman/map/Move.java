package botHackman.map;

import botHackman.MoveDirection;

public class Move {
    private final Position target;
    private final MoveDirection direction;

    public Move(Position p, MoveDirection d){
        this.direction = d;
        this.target = p;
    }

    public MoveDirection getDirection() {
        return direction;
    }

    public Position getTarget() {
        return target;
    }
}
