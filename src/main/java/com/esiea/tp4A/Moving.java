package com.esiea.tp4A;

import com.esiea.tp4A.domain.*;

public class Moving {

	private Position position;

	public Moving(char c, Position position) {
		this.position = position;
	}

	public Position analyse(char command) {
		switch (command) {
		case 'f':
			position = go_forward(position);
			break;
		case 'b':
			position = go_back(position);
			break;
		case 'l':
			position = rotate_left(position);
			break;
		case 'r':
			position = rotate_right(position);
			break;
		}
		return position;
	}

	public Position go_forward(Position position) {
		switch (position.getDirection()) {
		case NORTH:
			return Position.of(position.getX(), position.getY() + 1, position.getDirection());
		case SOUTH:
			return Position.of(position.getX(), position.getY() - 1, position.getDirection());
		case EAST:
			return Position.of(position.getX() + 1, position.getY(), position.getDirection());
		case WEST:
			return Position.of(position.getX() - 1, position.getY(), position.getDirection());
		default:
			return position;
		}
	}

	public Position go_back(Position position) {
		switch (position.getDirection()) {
		case NORTH:
			return Position.of(position.getX(), position.getY() - 1, position.getDirection());
		case SOUTH:
			return Position.of(position.getX(), position.getY() + 1, position.getDirection());
		case EAST:
			return Position.of(position.getX() - 1, position.getY(), position.getDirection());
		case WEST:
			return Position.of(position.getX() + 1, position.getY(), position.getDirection());
		default:
			return position;
		}
	}

	public Position rotate_right(Position position) {
		switch (position.getDirection()) {
		case NORTH:
			return Position.of(position.getX(), position.getY(), Direction.EAST);
		case SOUTH:
			return Position.of(position.getX(), position.getY(), Direction.WEST);
		case EAST:
			return Position.of(position.getX(), position.getY(), Direction.SOUTH);
		case WEST:
			return Position.of(position.getX(), position.getY(), Direction.NORTH);
		default:
			return position;
		}
	}

	public Position rotate_left(Position position) {
		switch (position.getDirection()) {
		case NORTH:
			return Position.of(position.getX(), position.getY(), Direction.WEST);
		case SOUTH:
			return Position.of(position.getX(), position.getY(), Direction.EAST);
		case EAST:
			return Position.of(position.getX(), position.getY(), Direction.NORTH);
		case WEST:
			return Position.of(position.getX(), position.getY(), Direction.SOUTH);
		default:
			return position;
		}
	}
}
