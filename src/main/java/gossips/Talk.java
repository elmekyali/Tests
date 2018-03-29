package gossips;

public class Talk {
    private Gossip Gossip;
    private String message;
    private boolean isAvailable;

    public Talk()
    {
        message = "";
        isAvailable = false;
    }


    public Gossip getGossip() {
        return Gossip;
    }

    public void setGossip(Gossip Gossip) {
        this.Gossip = Gossip;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public boolean isAvailable() {
        return isAvailable;
    }

    public void setAvailable(boolean available) {
        isAvailable = available;
    }
}
