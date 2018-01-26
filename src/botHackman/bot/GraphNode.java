package botHackman.bot;

import botHackman.MoveDirection;
import botHackman.map.Position;

public class GraphNode {
    final Position p;
    final Position root;
    final MoveDirection wayToRoot;
    final int distToRoot;

    public GraphNode(Position p, Position r, MoveDirection w, int d){
        this.p = p;
        this.root = r;
        this.wayToRoot = w;
        this.distToRoot = d;
    }
}
