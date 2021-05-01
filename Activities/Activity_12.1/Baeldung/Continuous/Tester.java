import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class Tester {
    @Test
    public void givenGreetingClient_whenServerRespondsWhenStarted_thenCorrect() throws Exception {
        GreetClient client = new GreetClient();
        client.startConnection("127.0.0.1", 6666);
        String response = client.sendMessage("hello server");
        assertEquals("hello client", response);
    }
}
