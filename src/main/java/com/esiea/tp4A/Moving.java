package com.esiea.tp4A;

import com.esiea.tp4A.domain.*;

public class Moving implements Position {

	private PositionPoint point;
    private Direction direction;

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
            case NORTH: point.getY_Forward(); break;
            case EAST: point.getX_Forward(); break;
            case SOUTH: point.getY_Back(); break;
            case WEST: point.getX_Back(); break;
        }
        return point;
    }

    public PositionPoint goBackward() {
        switch (direction) {
            case NORTH: point.getY_Back(); break;
            case EAST: point.getX_Back(); break;
            case SOUTH: point.getY_Forward(); break;
            case WEST: point.getX_Forward(); break;
        }
        return point;
    }

    @Override
    public int getX() {
        return point.getX();
    }

    @Override
    public int getY() {
        return point.getY();
    }

    @Override
    public Direction getDirection() {
        return direction;
    }
}
