package botHackman.map;

import botHackman.map.Field;

import java.util.ArrayList;

public class MapParser {

    private final Map map;

    MapParser(Map map){
        this.map = map;
    }

    void startBoard(String[] x){
        int width = this.map.getWidth();
        int height = this.map.getHeight();
        Field[][] board = this.map.getBoard();

        for(int i = 0; i < x.length; i++){
            if(!x[i].equals("x")) board[i % width][i / width].setAccesible();
        }
    }

    void updateObjects(String[] x){
        int width = this.map.getWidth();
        int height = this.map.getHeight();
        ArrayList<Player> players = new ArrayList<>();
        ArrayList<Snippet> snippets = new ArrayList<>();

        for(int i = 0; i < x.length; i++){
            Position p = new Position(i % width, i  / width);
            String[] fields = x[i].split(";");
            for(String f : fields){
                if(f.startsWith("P")){
                    int playerID = Character.getNumericValue(f.charAt(1));
                    players.add(new Player(map, p, playerID));
                }
                if(f.startsWith("C")){
                    snippets.add(new Snippet(map, p));
                }
            }
        }
        map.setPlayers(players);
        map.setSnippets(snippets);
    }

}
