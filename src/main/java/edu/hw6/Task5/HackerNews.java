package edu.hw6.Task5;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class HackerNews {
    private static final String HACKER_NEWS_ADDRESS = "https://hacker-news.firebaseio.com/v0/";

    public long[] hackerNewsTopStories() throws URISyntaxException {
        try (HttpClient client = HttpClient.newBuilder().version(HttpClient.Version.HTTP_1_1).build()) {
            return (hackerNewsTopStories(client));
        }
    }

    public String news(long id) throws URISyntaxException, IOException, InterruptedException {
        try (HttpClient client = HttpClient.newBuilder().version(HttpClient.Version.HTTP_1_1).build()) {
            return news(client, id);
        }
    }

    public long[] hackerNewsTopStories(HttpClient client) throws URISyntaxException {
        HttpRequest request = HttpRequest.newBuilder(new URI(HACKER_NEWS_ADDRESS + "topstories.json")).build();
        try {
            var responseBody = client.send(request, HttpResponse.BodyHandlers.ofString()).body();

            return Arrays.stream(responseBody.substring(1, responseBody.length() - 1).split(","))
                .mapToLong(Long::parseLong).toArray();

        } catch (IOException | InterruptedException e) {
            return new long[] {};
        }
    }

    public String news(HttpClient client, long id) throws URISyntaxException, IOException, InterruptedException {
        HttpRequest request = HttpRequest.newBuilder(new URI(HACKER_NEWS_ADDRESS + "item/" + id + ".json")).build();

        var responseBody = client.send(request, HttpResponse.BodyHandlers.ofString()).body();

        Matcher matcher = Pattern.compile("\"title\":\"([^\"]*)\"").matcher(responseBody);
        if (!matcher.find()) {
            throw new IllegalArgumentException("Illegal request body");
        }
        return matcher.group(1);

    }
}
