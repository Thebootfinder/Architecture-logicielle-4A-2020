package com.esiea.tp4A;

import com.esiea.tp4A.domain.Direction;
import com.esiea.tp4A.domain.Position;

public class Test {

	public static void main(String[] args) {

		Position position = Position.of(0, 0, Direction.NORTH);
		Rover marsrover = new Rover(position);
		marsrover.move("rbbf");
		System.out.printf(marsrover.position.getX() +" "+ marsrover.position.getY() +" "+ marsrover.position.getDirection());
	}

}
