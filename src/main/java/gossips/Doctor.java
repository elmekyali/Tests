package gossips;

public class Doctor extends Gossip {

    public Doctor(String name) {
        super(name);
    }

    public void say(String message) {
        if(getMessage().equals(""))
            setMessage(message);
        else{
            setMessage(getMessage() + ", " + message);
        }
    }

    public String ask() {
        return getMessage();
    }

    @Override
    public void spread(Gossip to) {

        to.say(getMessage());
    }

}
