package gossips;

public class GossipFactory {

    public Gossip getGossip(String personType , String personName)
    {
       switch (personType)
       {
           case "Mr" : return new Mister(personName);
           case "Dr" : return new Doctor(personName);
           case "Agent" : return new Agent(personName);
           case "Pr" : return new Professor(personName);
           case "Lady" : return new Lady(personName);
           default : return null;
       }
    }
}
