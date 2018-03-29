package gossips;

import java.util.LinkedList;
import java.util.List;

public class Agent extends Gossip {

    private List<Gossip> agentGossips = new LinkedList<>();

    public Agent(String name) {
        super(name);
    }

    public void say(String message) {
        if(getMessage().equals(""))
            setMessage(message);

    }

    public void say(){
        for (Gossip gossip : agentGossips) {
            if(getMessage().equals(""))
                setMessage(gossip.ask());
            else
                setMessage(getMessage() + ", " + gossip.ask());
        }
    }

    public String ask() {
        return getMessage();
    }

    public void spread(Gossip to) {
        System.out.println("i am in !!");
        setMessage("");
        agentGossips.clear();
    }

    public List<Gossip> getAgentGossips() {
        return agentGossips;
    }

}
