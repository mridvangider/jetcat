package org.jcoreutils;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class Receiver {
    private final BufferedReader bufferedReader;

    public Receiver(InputStream in)
    {
        bufferedReader = new BufferedReader(new InputStreamReader(in));
    }

    public void run()
    {
        String line;
        try {
            while ((line = bufferedReader.readLine()) != null)
            {
                System.out.println(line);
            }
        }
        catch (IOException e)
        {
            System.out.println("Got error while reading from the socket.");
            System.out.println(e.getLocalizedMessage());
            e.printStackTrace();
        }
    }

    protected void finalize() throws Throwable
    {
        bufferedReader.close();
    }
}
