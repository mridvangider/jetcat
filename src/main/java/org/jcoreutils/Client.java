package org.jcoreutils;

import java.io.*;
import java.net.InetAddress;
import java.net.Socket;
import java.net.StandardSocketOptions;

public class Client {
    private final Socket socket;
    public Client(InetAddress address, int port) throws Exception {
        socket = new Socket(address, port);
    }

    public void run() {
        try {
            Sender sender = new Sender(socket.getOutputStream());
            sender.run();
        } catch (Exception e) {
            System.out.println("Error while creating Sender.");
            System.out.println(e.getLocalizedMessage());
            e.printStackTrace();
        }
    }
    protected void finalize() throws Throwable {
        socket.close();
    }
}
