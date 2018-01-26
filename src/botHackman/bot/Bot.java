package botHackman.bot;

import botHackman.MoveDirection;
import botHackman.map.Map;
import botHackman.map.Move;
import botHackman.map.Position;
import botHackman.map.Snippet;

import java.util.LinkedList;
import java.util.Queue;

public class Bot {

    private final String botName;
    private final Map map;

    public Bot(String botName, Map map){
        this.botName = botName;
        this.map = map;
    }

    public String getBotName() {
        return botName;
    }

    public MoveDirection solve() {
        GraphNode paths[][] = setPaths();
        Position target = getTargetPosition(paths);
        if(target == null) return MoveDirection.PASS;

        GraphNode g = paths[target.getX()][target.getY()];
        while (g.root != this.map.getPlayer().getPosition()) g = paths[g.root.getX()][g.root.getY()];
        return g.wayToRoot;
    }

    public GraphNode[][] setPaths() {
        int width = this.map.getWidth();
        int height = this.map.getHeight();

        GraphNode distances[][] = new GraphNode[width][height];
        Queue<Position> q = new LinkedList<>();
        Position currPos = this.map.getPlayer().getPosition();
        q.add(currPos);
        distances[currPos.getX()][currPos.getY()] = new GraphNode(currPos, null,null,0);

        Position p;
        while(!q.isEmpty() && (p = q.remove()) != null)
        {
            GraphNode g = distances[p.getX()][p.getY()];
            for(Move validMoves : this.map.getValidMoves(p)){
                Position step = validMoves.getTarget();
                if(distances[step.getX()][step.getY()] != null) continue;

                distances[step.getX()][step.getY()] = new GraphNode(step, p, validMoves.getDirection(), g.distToRoot+1);
                q.add(step);
            }
        }

        return distances;
    }

    public Position getTargetPosition(GraphNode distances[][]){
        Position p = new Position(0,0);
        int dist = Integer.MAX_VALUE;
        for(Snippet snippet : this.map.getSnippets()){
            Position s = snippet.getPosition();
            if(distances[s.getX()][s.getY()] != null) {
                if (distances[s.getX()][s.getY()].distToRoot < dist) {
                    dist = distances[s.getX()][s.getY()].distToRoot;
                    p = s;
                }
            }
        }
        if(dist == Integer.MAX_VALUE) return null;
        return p;
    }

}
