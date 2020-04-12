package com.esiea.tp4A;

import java.util.Random;

public class Init {

    public int getRint(int max, int min){
        Random rand = new Random();
        return rand.nextInt(max - min + 1) + min;
    }
}
