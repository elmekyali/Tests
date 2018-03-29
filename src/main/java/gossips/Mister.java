package gossips;

public class Mister extends Gossip {

    public Mister(String name) {
        super(name);
    }

    public void say(String message) {
        setMessage(message);
    }

    public String ask() {
        return getMessage();
    }

    @Override
    public void spread(Gossip to) {
        to.say(getMessage());
        setMessage("");
    }



}
