package edu.hw7.Task1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.io.Reader;
import java.io.Writer;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.nio.charset.StandardCharsets;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Server {
    public static void start(int maxThreads) {
        try (ServerSocket serverSocket = new ServerSocket(8080);
             ExecutorService executorService = Executors.newFixedThreadPool(maxThreads)) {
            while (true) {
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

    private static void answer(Socket client) throws IOException {

        var request = new BufferedReader(new InputStreamReader((client.getInputStream()))).readLine();
        System.out.println(request);

        Writer writer = new OutputStreamWriter(client.getOutputStream(), StandardCharsets.UTF_8);
        PrintWriter out = new PrintWriter(writer, true);

        out.println("Hello, Worldwrwerw");

    }
}
