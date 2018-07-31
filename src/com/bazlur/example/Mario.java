package com.bazlur.example;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class Mario {
    private int lives = 0;

    public void addLives(){
        ScheduledExecutorService scheduler = Executors.newScheduledThreadPool(1);

        scheduler.scheduleAtFixedRate(new Runnable() {
            @Override
            public void run() {
               // this.lives ++;  // NOT possible
                System.out.println(lives);
            }
        }, 0,1, TimeUnit.SECONDS);


        scheduler.scheduleAtFixedRate(() -> {
            this.lives++; // just fine
            System.out.println(lives);
        }, 0,1, TimeUnit.SECONDS);
    }

    public static void main(String[] args) {
        Mario mario = new Mario();
        mario.addLives();
    }

}
