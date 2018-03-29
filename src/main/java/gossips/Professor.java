package gossips;

public class Professor extends Gossip {
    private boolean isDelayed = false;
    public Professor(String name) {
        super(name);
    }

    @Override
    public void spread(Gossip to) {

    }

    public void say(String message) {

    }

    public String ask() {
        return null;
    }

    public boolean isDelayed() {
        return isDelayed;
    }

    public void setDelayed(boolean delayed) {
        isDelayed = delayed;
    }
}
