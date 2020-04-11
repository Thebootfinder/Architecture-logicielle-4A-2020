package com.esiea.tp4A;

public class PositionPoint {
    private int X;
    private int Y;

    public PositionPoint(int X, int Y /* , Mettre mars */) {

        this.X = X;
        this.Y = Y;
        //  this.map = mars;
    }

    public int getX_Forward() {
        return X = X + 1;
    }

    public int getY_Forward() {
        return Y = Y + 1;
    }

    public int getX_Back() {
        return X = X - 1;
    }

    public int getY_Back() {
        return Y = Y - 1;
    }
    
    public int getY() { return Y; }
    
    public int getX() { return X; }

}
