package edu.hw6.Task5;

import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.net.URISyntaxException;
import static org.junit.jupiter.api.Assertions.*;

class HackerNewsTest {
    private final HackerNews hackerNews = new HackerNews();

    @Test
    void hackerNewsTopStories() throws URISyntaxException, IOException, InterruptedException {
        assertDoesNotThrow(hackerNews::hackerNewsTopStories);
        assertTrue(hackerNews.hackerNewsTopStories().length > 0);
    }

    @Test
    void news() throws URISyntaxException, IOException, InterruptedException {
        assertEquals("JDK 21 Release Notes", hackerNews.news(37570037));
    }
}
