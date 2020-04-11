package com.esiea.tp4A;

import com.esiea.tp4A.domain.MarsRover;

public class PositionPoint {
    private int X;
    private int Y;

    public PositionPoint(int X, int Y /* , Mettre mars */) {

        this.X = X;
        this.Y = Y;
        //  this.map = mars;
    }

    public PositionPoint() {
        X = 0;
        Y = 0;
    }


    public int getX_Forward() {
      X = X + 1;
    }

    public int getY_Forward() {
         Y = Y + 1;
    }

    public int getX_Back() {
         X = X - 1;
    }

    public int getY_Back() {
         Y = Y - 1;
    }


}
