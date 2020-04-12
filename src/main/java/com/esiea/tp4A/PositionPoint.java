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

    public int getX_Forward(boolean laser) { // Le laser a un comportement différent du Rover: d'où le boolean pour savoir si c'est l'un ou l'autre
        if(!mars.IsObstacleThere(X + 1, Y) || laser) {
        X = (X + 1) > mars.getCoordinates().getMaxX() ? mars.getCoordinates().getMinX() : X + 1;
        }
        return X;
    }

    public int getY_Forward(boolean laser) {
        if(!mars.IsObstacleThere(X, Y + 1) || laser) {
        Y = (Y + 1) > mars.getCoordinates().getMaxY() ? mars.getCoordinates().getMinY() : Y + 1;
        }
        return Y;
    }

    public int getX_Back(boolean laser) {
        if(!mars.IsObstacleThere(X - 1, Y) || laser) {
        X = (X - 1) < mars.getCoordinates().getMinX() ? mars.getCoordinates().getMaxX() : X - 1;
        }
        return X;
    }

    public int getY_Back(boolean laser) {
        if(!mars.IsObstacleThere(X, Y - 1) || laser) {
        Y = (Y - 1) < mars.getCoordinates().getMinY() ? mars.getCoordinates().getMaxY() : Y - 1;
        }
        return Y;
    }
    
    public int getY() { return Y; }
    
    public int getX() { return X; }

    public boolean checkNextPositionX(Direction direction) {
        int nextPosX;
        switch(direction) {
            case EAST: nextPosX = getX_Forward(true); break;
            case WEST: nextPosX = getX_Back(true); break;
            default: nextPosX = X; break;
        }
        if(!(mars.IsObstacleThere(nextPosX, Y))) {
            X = nextPosX;
            return true;
        }
        return false;
    }

    public boolean checkNextPositionY(Direction direction) {
        int nextPosY;
        switch(direction) {
            case NORTH: nextPosY = getY_Forward(true); break;
            case SOUTH: nextPosY = getY_Back(true); break;
            default: nextPosY = Y; break;
        }
        if(!(mars.IsObstacleThere(X, nextPosY))) {
            Y = nextPosY;
            return true;
        }
        return false;
    }
}
