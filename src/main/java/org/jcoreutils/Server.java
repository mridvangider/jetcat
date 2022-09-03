package org.jcoreutils;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.*;

public class Server {

    private final ServerSocket serverSocket;

    public Server(int port) throws Exception
    {
        serverSocket = new ServerSocket(port);
    }

    public void startListening() throws Exception
    {
        Socket client = serverSocket.accept();

        BufferedReader br = new BufferedReader(new InputStreamReader(client.getInputStream()));

        String line;

        while((line = br.readLine()) != null)
        {
            System.out.println(line+"\n");
        }

        br.close();
        client.close();
    }

    protected void finalize() throws Throwable
    {
        serverSocket.close();
    }
}