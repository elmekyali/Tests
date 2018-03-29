package gossips;

import parsers.DefaultParser;
import parsers.Parser;

public abstract class Gossip {

    protected final String name;
    protected String Message = "";
    Parser parser = new DefaultParser();

    public Gossip(String name) {
        this.name = name;
    }

    public abstract void say(String message);

    public abstract String ask();

    public abstract void spread(Gossip to);

    public String getMessage() {
        return Message;
    }

    public void setMessage(String message) {
        Message = message;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Gossip)) return false;

        Gossip Gossip = (Gossip) o;

        return name.equals(Gossip.name);
    }

    @Override
    public int hashCode() {
        return name.hashCode();
    }

    @Override
    public String toString() {
        return "Gossip{" +
                "name='" + name + '\'' +
                ", Message='" + Message + '\'' +
                '}';
    }
}
