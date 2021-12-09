package com.test;

import java.io.InputStream;
import java.net.URL;
import java.net.URLConnection;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicInteger;

public class UrlTest {
    public static void main(String[] args) {
        AtomicInteger atomicInteger = new AtomicInteger();
        ExecutorService executor = Executors.newFixedThreadPool(40);
        for (int i = 0; i < 60; i++) {
            Task task = new Task("task-" + i, atomicInteger);
            executor.execute(task);
        }
        executor.shutdown();
    }
}

class Task implements Runnable {
    public Task(String name, AtomicInteger atomicInteger) {
        this.name = name;
        this.atomicInteger = atomicInteger;
    }

    private String name;
    private AtomicInteger atomicInteger;

    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
//            String urlString = "http://localhost:8080/api/live-streams/401?userId=209035";
            String urlString = "http://appdev.qooco.com/api/live-streams/401?userId=209035";
            try {
                URL url = new URL(urlString);
                System.out.println(name + " run " + i);
                System.out.println("Value " + atomicInteger.incrementAndGet());
                URLConnection urlConnection = url.openConnection();
                InputStream inputStream = urlConnection.getInputStream();
                inputStream.close();
            } catch (Exception e) {

            }
        }
    }
}
