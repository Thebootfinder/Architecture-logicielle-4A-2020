package com.esiea.tp4A;


import com.esiea.tp4A.domain.Direction;

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

    public boolean checkNextPositionX(Direction direction) {
        int nextPosX = X;
        switch(direction) {
            case EAST: nextPosX = (X + 1) > mars.getCoordinates().getMaxX() ? mars.getCoordinates().getMinX() : X + 1; break;
            case WEST: nextPosX = (X - 1) < mars.getCoordinates().getMinX() ? mars.getCoordinates().getMaxX() : X - 1; break;
            default:
                break;
        }
        if(!(mars.IsObstacleThere(nextPosX, Y))) {
            X = nextPosX;
            return true;
        }
        return false;
    }

    public boolean checkNextPositionY(Direction direction) {
        int nextPosY = Y;
        switch(direction) {
            case NORTH: nextPosY = (Y + 1) > mars.getCoordinates().getMaxY() ? mars.getCoordinates().getMinY() : Y + 1; break;
            case SOUTH: nextPosY = Y = (Y - 1) < mars.getCoordinates().getMinY() ? mars.getCoordinates().getMaxY() : Y - 1; break;
            default:
                break;
        }
        if(!(mars.IsObstacleThere(X, nextPosY))) {
            Y = nextPosY;
            return true;
        }
        return false;
    }
}
