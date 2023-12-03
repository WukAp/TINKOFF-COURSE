package edu.hw7.Task1;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.io.Writer;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Server {
    public static int PORT = 8080;
    public static final String DEFAULT_PHRASE = "Я не хочу продолжать этот разговор";
    private final List<String> phrases;
    private final String FILE_NAME = "src/main/resources/hw7.Task1/phrases_for_Vanya";
    private volatile boolean isStopped = false;

    public Server() throws IOException {
        phrases = new ArrayList<>();
        readPhrasesFromFile();
    }

    public void start(int maxThreads) {
        try (ServerSocket serverSocket = new ServerSocket(PORT);
             ExecutorService executorService = Executors.newFixedThreadPool(maxThreads)) {
            while (!isStopped) {
                var socket = serverSocket.accept();
                executorService.submit(() -> {
                    try {
                        answer(socket);
                        socket.close();
                    } catch (IOException e) {
                        throw new RuntimeException(e);
                    }
                });
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void stop() {
        isStopped = false;
    }

    private void answer(Socket client) throws IOException {

        var request = new BufferedReader(new InputStreamReader((client.getInputStream()))).readLine();
        Writer writer = new OutputStreamWriter(client.getOutputStream(), StandardCharsets.UTF_8);
        PrintWriter out = new PrintWriter(writer, true);

        out.println(getPhrase(request));

    }

    private void readPhrasesFromFile() throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader(FILE_NAME));
        String line = reader.readLine();
        while (line != null) {
            phrases.add(line);
            line = reader.readLine();
        }
        reader.close();
    }

    private String getPhrase(String keyWord) {
        for (String phrase : phrases) {
            if (phrase.toUpperCase().contains(keyWord.toUpperCase())) {
                return phrase;
            }
        }
        return DEFAULT_PHRASE;
    }

}

