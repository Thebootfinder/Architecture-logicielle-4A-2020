package com.esiea.tp4A;

import com.esiea.tp4A.domain.*;

public class Moving implements Position {

	public PositionPoint point;
    public Direction direction;

    public Moving(PositionPoint point, Direction direction) {
        this.point = point;
        this.direction = direction;
    }


    public Direction rotateLeft() {
        return direction = direction.rotateLeft();
    }

    public Direction rotateRight() {
        return direction = direction.rotateRight();
    }

    public PositionPoint goForward() {
        switch (direction) {
            case NORTH: point.Y_forward(); break;
            case EAST: point.X_forward(); break;
            case SOUTH: point.Y_back(); break;
            case WEST: point.X_back(); break;
        }
        return point;
    }

    public PositionPoint goBackward() {
        switch(direction) {
            case NORTH: point.Y_back(); break;
            case EAST: point.X_back(); break;
            case SOUTH: point.Y_forward(); break;
            case WEST: point.X_forward(); break;
        }
        return point;
    }

    @Override
    public int getX() {
        return point.X;
    }

    @Override
    public int getY() {
        return point.Y;
    }

    @Override
    public Direction getDirection() {
        return direction;
    }
}
