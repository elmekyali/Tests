package parsers;


import gossips.Gossip;

public interface Parser {
    Gossip parseNameWithType(String name, String seperator);
    String parseName(String name, String seperator);
    String parseMessage(String message, String seperator);
}
