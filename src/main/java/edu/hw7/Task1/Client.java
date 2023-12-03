package edu.hw7.Task1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.io.Writer;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;
import java.nio.charset.StandardCharsets;

public class Client {

    public static void main(String[] args) throws IOException {
        try (Socket client = new Socket(InetAddress.getByName("localhost"), 8080)) {

            InputStream is = client.getInputStream();
            OutputStream os = client.getOutputStream();
            Writer writer = new OutputStreamWriter(os, StandardCharsets.UTF_8);
            PrintWriter out = new PrintWriter(writer, true);
            out.println("Hello, Worldwrwerw");
            BufferedReader in =
                new BufferedReader
                    (new InputStreamReader(is, StandardCharsets.UTF_8));

            var response = new BufferedReader(new InputStreamReader((client.getInputStream()))).readLine();
            System.out.println(response);
        }
    }
}
