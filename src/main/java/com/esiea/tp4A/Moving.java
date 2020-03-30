package com.esiea.tp4A;

import com.esiea.tp4A.domain.*;

public class Moving implements Position {

	public Direction direction;
	public PositionPoint point;

	public Moving(Direction direction, PositionPoint point) {
		this.direction = direction;
		this.point = point;
	}

	public PositionPoint go_forward() {
		switch(direction) {
			case NORTH: point.Y_forward();
			case EAST: point.X_forward();
			case SOUTH: point.Y_back();
			case WEST: point.X_back();
		}
		return point;
	}

	public PositionPoint go_back() {
		switch(direction) {
			case NORTH: point.Y_back();
			case EAST: point.X_back();
			case SOUTH: point.Y_forward();
			case WEST: point.X_forward();
		}
		return point;
	}

	public Direction rotate_right() {
		return direction = direction.rotateRight();
	}

	public Direction rotate_left() {
		return direction = direction.rotateLeft();
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
