
import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class GossipsTest {

    @Test
    public void bePropagatedByAnyMister() {

        Gossips gossips = new Gossips("Mr White", "Mr Black", "Mr Blue")
                .from("White").to("Black").from("Black").to("Blue");

        gossips.say("Hello").to("White");

        assertEquals(gossips.ask("White"), "Hello");

        gossips.spread();

        assertEquals(gossips.ask("White"), "");
        assertEquals(gossips.ask("Black"), "Hello");

        gossips.spread();

        assertEquals(gossips.ask("Black"), "");
        assertEquals(gossips.ask("Blue"), "Hello");

    }

    @Test
    public void beRetainedIfRecipientHasAlreadyAGossip() {

        Gossips gossips = new Gossips("Mr White", "Mr Black", "Mr Blue")
                .from("White").to("Black").from("Blue").to("Black");

        gossips.say("Hello").to("White");
        gossips.say("Secret").to("Blue");

        assertEquals(gossips.ask("White"), "Hello");
        assertEquals(gossips.ask("Blue"), "Secret");

        gossips.spread();

        assertEquals(gossips.ask("White"), "");
        assertEquals(gossips.ask("Black"), "Hello");
        assertEquals(gossips.ask("Blue"), "Secret");

        gossips.spread();

        assertEquals(gossips.ask("White"), "");
        assertEquals(gossips.ask("Black"), "Secret");
        assertEquals(gossips.ask("Blue"), "");

    }

    @Test
    public void beRememberedByDoctors() {

        Gossips gossips = new Gossips("Mr White", "Mr Black", "Dr Brown",
                "Mr Pink").from("White").to("Brown").from("Black").to("Brown")
                .from("Brown").to("Pink");

        gossips.say("Hello").to("White");
        gossips.say("ByeBye").to("Black");

        gossips.spread();

        assertEquals(gossips.ask("Brown"),"Hello");
        assertEquals(gossips.ask("Pink"),"");

        gossips.spread();
        assertEquals(gossips.ask("Brown"),"Hello, ByeBye");
        assertEquals(gossips.ask("Pink"),"Hello");

        gossips.spread();

        assertEquals(gossips.ask("Brown"),"Hello, ByeBye");
        assertEquals(gossips.ask("Pink"),"ByeBye");

    }

    @Test
    public void alwaysBeListenedByAnAgent() {

        Gossips gossips = new Gossips("Mr White", "Mr Grey", "Agent Pink",
                "Mr Blue").from("White").to("Pink").from("Grey").to("Pink")
                .from("Pink").to("Blue");

        gossips.say("Hello").to("White");
        gossips.say("Shade").to("Grey");

        gossips.spread();

        assertEquals(gossips.ask("Blue"),"");
        assertEquals(gossips.ask("Blue"),"");
        assertEquals(gossips.ask("Pink"),"Hello, Shade");

        gossips.spread();

        assertEquals(gossips.ask("Pink"),"");
        assertEquals(gossips.ask("Blue"),"");
    }

    @Test
    public void beStoppedByAnAgent() {

        Gossips gossips = new Gossips("Mr White", "Agent Pink", "Mr Blue")
                .from("White").to("Pink").from("Pink").to("Blue");

        gossips.say("Hello").to("White");

        gossips.spread();

        assertEquals(gossips.ask("Pink"),"Hello");
        assertEquals(gossips.ask("Blue"),"");

        gossips.spread();

        assertEquals(gossips.ask("Pink"),"");
        assertEquals(gossips.ask("Blue"),"");
    }

    @Test
    public void beDelayedOneTurnByAProfessor() {

        Gossips gossips = new Gossips("Mr White", "Pr Pink", "Mr Blue")
                .from("White").to("Pink").from("Pink").to("Blue");

        gossips.say("Hello").to("White");

        gossips.spread();

        assertEquals(gossips.ask("Pink"),"Hello");
        assertEquals(gossips.ask("Blue"),"");

        gossips.spread();

        assertEquals(gossips.ask("Pink"),"Hello");
        assertEquals(gossips.ask("Blue"),"");

        gossips.spread();

        assertEquals(gossips.ask("Pink"),"");
        assertEquals(gossips.ask("Blue"),"Hello");
    }

    @Test
    public void bePropagatedByALadyWhenComingFromADoctor() {

        Gossips gossips = new Gossips("Dr Black", "Lady Green", "Agent Pink")
                .from("Black").to("Green").from("Green").to("Pink");

        gossips.say("Secret").to("Black");

        gossips.spread();

        assertEquals(gossips.ask("Green"),"Secret");

        gossips.spread();

        assertEquals(gossips.ask("Pink"),"Secret");

    }

    @Test
    public void notBePropagatedByALadyWhenComingAMister() {

        Gossips gossips = new Gossips("Mr White", "Lady Green", "Agent Pink")
                .from("White").to("Green").from("Green").to("Pink");

        gossips.say("Hello").to("White");

        gossips.spread();

        assertEquals(gossips.ask("Green"),"Hello");

        gossips.spread();

        assertEquals(gossips.ask("Pink"),"");

    }

    @Test
    public void beReturnedAndInvertedByGentlemen() {

        Gossips gossips = new Gossips("Mr White", "Sir Rose", "Mr Black")
                .from("White").to("Rose").from("Rose").to("Black");

        gossips.say("Hello").to("White");

        gossips.spread();

        assertEquals(gossips.ask("White"),"");
        assertEquals(gossips.ask("Rose"),"Hello");
        assertEquals(gossips.ask("Black"),"");

        gossips.spread();

        assertEquals(gossips.ask("White"),"olleH");
        assertEquals(gossips.ask("Rose"),"");
        assertEquals(gossips.ask("Black"),"");

        gossips.spread();

        assertEquals(gossips.ask("White"),"");
        assertEquals(gossips.ask("Rose"),"olleH");
        assertEquals(gossips.ask("Black"),"");
    }

}
