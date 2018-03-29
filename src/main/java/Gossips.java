
import gossips.Gossip;
import gossips.Talk;
import parsers.DefaultParser;
import parsers.Parser;

import java.util.*;

public class Gossips {

    private Map<Gossip, Gossip> discussion = new LinkedHashMap<>();
    private Map<String , Gossip> Gossips = new HashMap<>();
    private Parser parser = new DefaultParser();
    private String gossip = null;
    private String message = "";

    public Gossips(String... names)
    {
        for (String name : names)
        {
            Gossips.put(parser.parseName(name , " ") , parser.parseNameWithType(name , " "));
            discussion.put(Gossips.get(parser.parseName(name , " ")) , null);
        }
    }

    public Gossips from(String Gossip)
    {
        gossip = Gossip;
        return this;
    }

    public Gossips to(String Gossip)
    {
        if(gossip == null)
        {
            throw new IllegalStateException();
        }
        else if(message.equals(""))
        {
            Gossip from = Gossips.get(gossip);
            Gossip to   = Gossips.get(Gossip);
            discussion.put(from , to);
        }
        if(!message.equals(""))
        {
            Gossips.get(Gossip).say(message);
            message = "";
        }
        return this;
    }

    public Gossips say(String message)
    {
        this.message = message;
        return this;
    }

    public String ask(String Gossip)
    {
        return Gossips.get(Gossip).ask();
    }

    public void spread()
    {
        System.out.println("************************");
        for (Map.Entry<Gossip , Gossip> discussionEntry : discussion.entrySet())
        {
            Gossip from = discussionEntry.getKey();
            Gossip to = discussionEntry.getValue();
            System.out.println(from + "\t --> " + to);
            if(!from.ask().equalsIgnoreCase("") && to !=null){
                from.spread(to);
                break;
            }
        }
    }
}
