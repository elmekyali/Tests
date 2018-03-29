
import gossips.Agent;
import gossips.Doctor;
import gossips.Gossip;
import parsers.DefaultParser;
import parsers.Parser;

import java.util.*;

public class Gossips {

    private Map<Gossip, Gossip> discussion = new LinkedHashMap<>();
    private Map<String , Gossip> gossips = new HashMap<>();
    private Parser parser = new DefaultParser();
    private String gossip = null;
    private String message = "";

    public Gossips(String... names)
    {
        for (String name : names)
        {
            gossips.put(parser.parseName(name , " ") , parser.parseNameWithType(name , " "));
            discussion.put(gossips.get(parser.parseName(name , " ")) , null);
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
            Gossip from = gossips.get(gossip);
            Gossip to   = gossips.get(Gossip);

            if(from instanceof Doctor)
                ((Doctor) from).getNextGossips().add(to);
            if (to instanceof Agent)
                ((Agent) to).getAgentGossips().add(from);

            discussion.put(from , to);
        }
        if(!message.equals(""))
        {
            gossips.get(Gossip).say(message);
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
        return gossips.get(Gossip).ask();
    }

    public void spread()
    {
        for (Map.Entry<String , Gossip> gossip : gossips.entrySet()) {
            if ((gossip.getValue() instanceof Agent) && ((Agent) gossip.getValue()).getAgentGossips().isEmpty()) {
                ((Agent) gossip.getValue()).say();
            }
        }
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
