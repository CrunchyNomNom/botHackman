package botHackman.engine;

import botHackman.MoveDirection;

public class Output {
    public void playerName(String x) {
        System.out.println(x);
    }

    public void move(MoveDirection m){
        switch (m){
            case UP:
                System.out.println("up");
                return;
            case DOWN:
                System.out.println("down");
                return;
            case RIGHT:
                System.out.println("right");
                return;
            case LEFT:
                System.out.println("left");
                return;
            default:
                System.out.println("pass");
                return;
        }
    }
}
