package com.esiea.tp4A;

public class PositionPoint {
	private int X;
    private int Y;

    public PositionPoint(int X, int Y){
        this.X = X;
        this.Y = Y;
    }

    public void X_forward(){
        X = X + 1;
    }

    public void X_back(){
        X = X - 1;
    }
    public void Y_forward(){
        Y = Y + 1;
    }
    public void Y_back(){
        Y = Y - 1;
    }
}
