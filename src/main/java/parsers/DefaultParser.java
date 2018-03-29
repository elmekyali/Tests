package parsers;


import gossips.Gossip;
import gossips.GossipFactory;

public class DefaultParser implements Parser {

    @Override
    public Gossip parseNameWithType(String name, String seperator) {
        GossipFactory Gossip = new GossipFactory();
        String[] nameAndType = name.split(seperator);
        return Gossip.getGossip(nameAndType[0] , nameAndType[1]);
    }

    @Override
    public String parseName(String name, String seperator) {
        String[] nameT = name.split(seperator);
        return (nameT.length == 1) ? name : nameT[1];
    }

    @Override
    public String parseMessage(String message, String seperator) {
        String[] Messages = message.split(seperator);
        return (Messages.length == 1) ? message : Messages[Messages.length - 1];
    }
}
