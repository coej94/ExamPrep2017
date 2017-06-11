/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.sp2;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.atomic.AtomicLong;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Staal
 */
public class producerconsumer {

    private static ArrayBlockingQueue<Long> s1 = new ArrayBlockingQueue<>(11);
    private static ArrayBlockingQueue<Long> s2 = new ArrayBlockingQueue<>(11);

    private static final Thread producer1 = new Thread();
    private static Thread producer2 = new Thread();
    private static Thread producer3 = new Thread();
    private static Thread producer4 = new Thread();

    

    private static long sum = 0;

    //4,5,8,12,21,22,34,35,36,37,42
    public static void main(String[] args) throws InterruptedException {
        s1.add(4L);
        s1.add(5L);
        s1.add(8L);
        s1.add(12L);
        s1.add(21L);
        s1.add(22L);
        s1.add(34L);
        s1.add(35L);
        s1.add(36L);
        s1.add(37L);
        s1.add(42L);

        producer1.start();
        producer2.start();
        producer3.start();
        producer4.start();

        Thread t = new Thread(new Runnable() {
            public void run() {
                while (!s1.isEmpty()) {

                    try {
                        long b1;

                        b1 = Long.parseLong(String.valueOf(s1.take()));
                        s2.add(fib(b1));

                    } catch (InterruptedException ex) {
                        Logger.getLogger(producerconsumer.class.getName()).log(Level.SEVERE, null, ex);
                    }

                }
            }
        });
        t.start();

        Thread consumer = new Thread(new Runnable() {
            public void run() {

                    
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException ex) {
                    Logger.getLogger(producerconsumer.class.getName()).log(Level.SEVERE, null, ex);
                }
                while (!s2.isEmpty()) {
                    

                    long lort = s2.poll();
                    sum += lort;
                    
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException ex) {
                        Logger.getLogger(producerconsumer.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
        System.out.println(sum);
            }
            
        });
        consumer.start();

        Thread.sleep(2000);
        System.out.println(s2);

        

    }

    private static long fib(long n) {
        if ((n == 0) || (n == 1)) {
            return n;
        } else {
            return fib(n - 1) + fib(n - 2);
        }
    }

}
