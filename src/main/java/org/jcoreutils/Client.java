package org.jcoreutils;

import java.io.*;
import java.net.StandardSocketOptions;

public class Client {
    public static class Speaker implements Runnable {
        private final BufferedReader bufferedReader;

        public Speaker(InputStream in)
        {
            bufferedReader = new BufferedReader(new InputStreamReader(in));
        }

        @Override
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
}
