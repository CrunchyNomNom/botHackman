package botHackman.engine;

import java.util.Scanner;

public class Input {
    private final Scanner scanner;
    private State state;

    public Input(State state){
        this.scanner = new Scanner(System.in);
        this.state = state;
    }

    public String[] read() {
        while(scanner.hasNextLine()){
            String line = scanner.nextLine();
            if(line.length() == 0) continue;

            String[] parts = line.split(" ");
            switch(parts[0]){
                case "settings":
                    parseSettings(parts[1], parts[2]);
                    break;
                case "update":
                    if (parts[1].equals("game")) {
                        parseGame(parts[2], parts[3]);
                    }
                    else {
                        parsePlayer(parts[1], parts[2], parts[3]);
                    }
                    break;
                case "action":
                    return parts;
                default:
                    System.err.println("Wrong input");
                    break;
            }
        }
        return null;
    }

    private void parseSettings(String key, String value) {
        try {
            switch(key) {
                case "timebank":
                    int time = Integer.parseInt(value);
                    this.state.setMAX_TIMEBANK(time);
                    this.state.setTimebank(time);
                    break;
                case "time_per_move":
                    this.state.setMAX_MOVE_TIME(Integer.parseInt(value));
                    break;
                case "player_names":
                    String[] names = value.split(",");
                    this.state.setPlayerName(names[0]);
                    this.state.setEnemyName(names[1]);
                    break;
                case "your_bot":
                    if(!this.state.getPlayerName().equals(value)) {
                        this.state.setEnemyName(this.state.getPlayerName());
                        this.state.setPlayerName(value);
                    }
                    break;
                case "your_botid":
                    int myid = Integer.parseInt(value);
                    int enemyid = 2 - (myid + 1);
                    this.state.setPlayerID(myid);
                    this.state.setEnemyID(enemyid);
                    break;
                case "field_width":
                    this.state.setBOARD_WIDHT(Integer.parseInt(value));
                    break;
                case "field_height":
                    this.state.setBOARD_HEIGHT(Integer.parseInt(value));
                    break;
                case "max_rounds":
                    this.state.setMAX_ROUNDS(Integer.parseInt(value));
                    break;
                default:
                    System.err.println(String.format(
                            "Cannot parse settings input with key '%s'", key));
            }
        } catch (Exception e) {
            System.err.println(String.format(
                    "Cannot parse settings value '%s' for key '%s'", value, key));
            e.printStackTrace();
        }
    }

    private void parseGame(String key, String value) {
        try {
            switch(key) {
                case "round":
                    this.state.setCurrentRound(Integer.parseInt(value));
                    break;
                case "field":
                    this.state.setBoardUpdate(value);
                    break;
                default:
                    System.err.println(String.format(
                            "Cannot parse game data input with key '%s'", key));
            }
        } catch (Exception e) {
            System.err.println(String.format(
                    "Cannot parse game data value '%s' for key '%s'", value, key));
            e.printStackTrace();
        }
    }

    private void parsePlayer(String playerName, String key, String value) {
        try {
            if (this.state.getPlayerName().equals(playerName)) {
                switch (key) {
                    case "bombs":
                        this.state.setPlayerBombs(Integer.parseInt(value));
                        break;
                    case "snippets":
                        this.state.setPlayerSnippets(Integer.parseInt(value));
                        break;
                    default:
                        System.err.println(String.format("Cannot parse %s data input with key '%s'", playerName, key));
                }
            }
            else {
                switch(key) {
                    case "bombs":
                        this.state.setEnemyBombs(Integer.parseInt(value));
                        break;
                    case "snippets":
                        this.state.setEnemySnippets(Integer.parseInt(value));
                        break;
                    default:
                        System.err.println(String.format("Cannot parse %s data input with key '%s'", playerName, key));
            }
            }
        } catch (Exception e) {
            System.err.println(String.format("Cannot parse %s data value '%s' for key '%s'", playerName, value, key));
            e.printStackTrace();
        }
    }
}
