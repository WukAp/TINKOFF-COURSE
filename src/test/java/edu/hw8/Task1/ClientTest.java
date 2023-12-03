package edu.hw8.Task1;

import org.junit.jupiter.api.Test;

import java.io.IOException;
import static org.junit.jupiter.api.Assertions.*;

class ClientTest {
    private final Client client = new Client();
    private final Server server = new Server();
    private final Thread thread = new Thread(() -> server.start(10));

    ClientTest() throws IOException {

    }

    @Test
    void getPhraseFromServer() throws IOException, InterruptedException {
        thread.start();
Thread.sleep(2000);
    assertDoesNotThrow(() -> client.getPhraseFromServer("противники"));
        assertEquals(
            "Если твои противники перешли на личные оскорбления, будь уверена — твоя победа не за горами",
            client.getPhraseFromServer("противники")
        );
        assertEquals(
            "Я не хочу продолжать этот разговор",
            client.getPhraseFromServer("чтоточточто")
        );

        for (int i = 0; i < 100; i++) {
            assertEquals(
                "Если твои противники перешли на личные оскорбления, будь уверена — твоя победа не за горами",
                client.getPhraseFromServer("противники")
            );
        }
        server.stop();
    }

}
