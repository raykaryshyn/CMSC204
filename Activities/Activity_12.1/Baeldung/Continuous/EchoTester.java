import static org.junit.Assert.assertEquals;

import org.junit.*;

public class EchoTester {
    EchoClient client;

    @Before
    public void setup() throws Exception {
        client = new EchoClient();
        client.startConnection("127.0.0.1", 4444);
    }

    @After
    public void tearDown() throws Exception {
        client.stopConnection();
    }

    @Test
    public void testEcho() throws Exception {
        String resp1 = client.sendMessage("hello");
        String resp2 = client.sendMessage("world");
        String resp3 = client.sendMessage("!");
        String resp4 = client.sendMessage(".");

        System.out.println(resp1);
        System.out.println(resp2);
        System.out.println(resp3);
        System.out.println(resp4);

        assertEquals("hello", resp1);
        assertEquals("world", resp2);
        assertEquals("!", resp3);
        assertEquals("goodbye", resp4);
    }
}
