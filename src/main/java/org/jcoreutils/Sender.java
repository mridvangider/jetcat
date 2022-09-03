package org.jcoreutils;

import java.io.*;

public class Sender {
    private final BufferedWriter bufferedWriter;

    public Sender(OutputStream out) {
        bufferedWriter = new BufferedWriter(new OutputStreamWriter(out));
    }

    public void run() {
        BufferedReader lineReader = new BufferedReader(new InputStreamReader(System.in));

        String line;
        try {
            while (true) {
                line = lineReader.readLine();
                if (line.equalsIgnoreCase("!exit")) {
                    break;
                }
                bufferedWriter.write(line);
            }
        } catch (Exception e) {
            System.out.println("Error while reading input.");
            System.out.println(e.getLocalizedMessage());
            e.printStackTrace();
        }
    }

    protected void finalize() throws Throwable {
        bufferedWriter.close();
    }
}
