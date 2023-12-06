package edu.hw6.Task5;

import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.net.URISyntaxException;
import java.net.http.HttpClient;
import static org.junit.jupiter.api.Assertions.*;

class HackerNewsTest {
    private final HackerNews hackerNews = new HackerNews();

    @Test void hackerNewsTopStories() throws URISyntaxException {
        assertDoesNotThrow(() -> hackerNews.hackerNewsTopStories());
        assertTrue(hackerNews.hackerNewsTopStories().length > 0);

        try (HttpClient client = HttpClient.newBuilder().version(HttpClient.Version.HTTP_1_1).build()) {
            assertDoesNotThrow(() -> hackerNews.hackerNewsTopStories(client));
            assertTrue(hackerNews.hackerNewsTopStories(client).length > 0);
        }
    }

    @Test void news() throws URISyntaxException, IOException, InterruptedException {
        assertEquals("JDK 21 Release Notes", hackerNews.news(37570037));
        try (HttpClient client = HttpClient.newBuilder().version(HttpClient.Version.HTTP_1_1).build()) {
            assertDoesNotThrow(() -> hackerNews.news(client, 37570037));
            assertEquals("JDK 21 Release Notes", hackerNews.news(client, 37570037));
        }
    }
}
