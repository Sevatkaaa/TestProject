package com.test;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class Multithreading {
    public static void main(String[] args) {
        AtomicInteger atomicInteger = new AtomicInteger();
//        IntCallable intCallable = new IntCallable();
//        ExecutorService singleService = Executors.newSingleThreadExecutor();
//        Future<Integer> submit = singleService.submit(intCallable);
//        try {
//            Integer integer = submit.get();
//            System.out.println(integer);
//        } catch (InterruptedException | ExecutionException e) {
//            e.printStackTrace();
//        }
        ExecutorService poolService = Executors.newFixedThreadPool(50);
        Chess chess = new Chess();
        chess.pieces.add(new King());
        chess.pieces.add(new Pawn());
        for (int i = 0; i < 200; i++) {
            poolService.submit(() -> {
                chess.printAllPieces();
                System.out.println(Thread.currentThread().getName());
            });
        }
        Thread thread = new Thread(() -> {
            chess.printAllPieces();
            System.out.println(Thread.currentThread().getName());
        });
        thread.setDaemon(true);
//        thread.start();
        poolService.shutdown();
        Semaphore semaphore = new Semaphore(2);
        try {
            semaphore.acquire();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        semaphore.release(2);
    }
}

class IntCallable implements Callable<Integer> {

    @Override
    public Integer call() {
        return 1;
    }
}

class Chess {
    List<Piece> pieces = new ArrayList<>();
    ReadWriteLock lock = new ReentrantReadWriteLock();

    public void printAllPieces() {
        lock.readLock().lock();
        try {
            pieces.stream().forEach(System.out::println);
        } finally {
            lock.readLock().unlock();
        }
        lock.writeLock().lock();
        try {
            pieces.add(new Piece());
        } finally {
            lock.writeLock().unlock();
        }
    }
}

class Piece {

}

class Pawn extends Piece {

}

class King extends Piece {

}
