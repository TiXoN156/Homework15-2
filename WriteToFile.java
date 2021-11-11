package com.company;

import java.io.PrintWriter;

public class WriteToFile extends Thread{
    private PrintWriter printWriter = null;
    private String string;

    public WriteToFile(PrintWriter printWriter, String string) {
        this.printWriter = printWriter;
        this.string = string;
    }

    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            try {
                Thread.sleep(20);
                printWriter.println(string);
                printWriter.flush();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
