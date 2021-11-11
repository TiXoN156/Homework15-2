package com.company;

import java.io.FileNotFoundException;
import java.io.PrintWriter;

public class Main {

    public static void main(String[] args) {
        PrintWriter printWriter = null;
        try {
            printWriter = new PrintWriter("output.txt");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        Thread thread1 = new Thread(new WriteToFile(printWriter, "Запись потока 1"));
        Thread thread2 = new Thread(new WriteToFile(printWriter, "Запись потока 2"));
        Thread thread3 = new Thread(new WriteToFile(printWriter, "Запись потока 3"));
        try {
            thread1.start();
            thread1.join();
            thread2.start();
            thread2.join();
            thread3.start();
            thread3.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        printWriter.close();
    }
}
