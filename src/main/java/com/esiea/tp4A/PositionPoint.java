package com.esiea.tp4A;


public class PositionPoint {
	private int X;
    private int Y;
    private final Mars mars;

    public PositionPoint(int X, int Y, Mars mars) {

        this.X = X;
        this.Y = Y;
        this.mars = mars;
    }

    public int getX_Forward() {
        if(!mars.IsObstacleThere(X + 1, Y)) {
        X = (X + 1) > mars.getCoordinates().getMaxX() ? mars.getCoordinates().getMinX() : X + 1;
        }
        return X;
    }

    public int getY_Forward() {
        if(!mars.IsObstacleThere(X, Y + 1)) {
        Y = (Y + 1) > mars.getCoordinates().getMaxY() ? mars.getCoordinates().getMinY() : Y + 1;
        }
        return Y;
    }

    public int getX_Back() {
        if(!mars.IsObstacleThere(X - 1, Y)) {
        X = (X - 1) < mars.getCoordinates().getMinX() ? mars.getCoordinates().getMaxX() : X - 1;
        }
        return X;
    }

    public int getY_Back() {
        if(!mars.IsObstacleThere(X, Y - 1)) {
        Y = (Y - 1) < mars.getCoordinates().getMinY() ? mars.getCoordinates().getMaxY() : Y - 1;
        }
        return Y;
    }
    
    public int getY() { return Y; }
    
    public int getX() { return X; }
}
