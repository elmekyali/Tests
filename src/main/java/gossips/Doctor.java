package gossips;

import java.util.LinkedList;
import java.util.List;

public class Doctor extends Gossip {

    private List<Gossip> nextGossips = new LinkedList<>();

    public Doctor(String name) {
        super(name);
    }

    public void say(String message) {
        if(getMessage().equals(""))
            setMessage(message);
        else{
            for (Gossip gossip : nextGossips) {
                gossip.say(parser.parseMessage(getMessage() , ", "));
            }
            setMessage(getMessage() + ", " + message);
        }
    }

    public String ask() {
        return getMessage();
    }

    @Override
    public void spread(Gossip to) {
        to.say(parser.parseMessage(getMessage() , ", "));
    }

    public List<Gossip> getNextGossips() {
        return nextGossips;
    }

}
