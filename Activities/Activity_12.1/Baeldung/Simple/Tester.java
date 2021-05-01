import static org.junit.Assert.assertEquals;

import org.junit.*;

public class Tester {
    EchoClient client;

    @Before
    public void setup() throws Exception {
        client = new EchoClient();
        client.startConnection("127.0.0.1", 6666);
    }

    @After
    public void tearDown() throws Exception {
        client.stopConnection();
    }

    @Test
    public void givenEchoingClient_whenServerRespondsWhenStarted_thenCorrect() throws Exception {
        String resp1 = client.sendMessage("hello");
        String resp2 = client.sendMessage("world");
        String resp3 = client.sendMessage("!");
        String resp4 = client.sendMessage(".");

        assertEquals("hello", resp1);
        assertEquals("world", resp2);
        assertEquals("!", resp3);
        assertEquals("good bye", resp4);
    }
}
