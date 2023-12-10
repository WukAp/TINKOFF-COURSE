package edu.hw8.Task1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.io.Writer;
import java.net.InetAddress;
import java.net.Socket;
import java.nio.charset.StandardCharsets;

public class Client {
    public static final int PORT = Server.PORT;

    public String getPhraseFromServer(String keyWord) throws IOException {
        try (Socket client = new Socket(InetAddress.getLocalHost(), PORT)) {

            OutputStream os = client.getOutputStream();
            Writer writer = new OutputStreamWriter(os, StandardCharsets.UTF_8);
            PrintWriter out = new PrintWriter(writer, true);
            out.println(keyWord);

            return new BufferedReader(new InputStreamReader((client.getInputStream()))).readLine();
        }
    }
}
