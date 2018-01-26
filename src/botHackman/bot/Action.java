package botHackman.bot;

import botHackman.engine.*;
import botHackman.map.Map;

public class Action {

    final Bot bot;
    final State state;
    final Map map;
    final Input input;
    final Output output;

    public Action(String botName) {
        this.state = new State();
        this.map = new Map(this.state);
        this.bot = new Bot(botName, this.map);
        this.input = new Input(this.state);
        this.output = new Output();
    }

    public void run() {
        String[] action = input.read();
        if(action[1].equals("character")) output.playerName(bot.getBotName());

        boolean started = false;
        while(action != null)
        {
            if(!started){
                this.map.start();
                started = true;
            }

            if(action[1].equals("move")){
                this.map.update();
                output.move(bot.solve());
            }

            action = input.read();
        }
    }

}
