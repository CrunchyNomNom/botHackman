package botHackman.map;

public class Snippet {

    final Map map;
    final Position position;

    public Snippet(Map map, Position p){
        this.map = map;
        this.position = p;
    }

    public Position getPosition() {
        return position;
    }
}
