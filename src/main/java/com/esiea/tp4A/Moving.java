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
