package com.esiea.tp4A;

import com.esiea.tp4A.domain.Direction;
import com.esiea.tp4A.domain.Position;

public class Test {

	public static void main(String[] args) {

		PositionPoint position = new PositionPoint(0, 0);
		
		Moving moving = new Moving(position, Direction.NORTH); 
		Rover marsrover = new Rover(moving);
		marsrover.move("rbbf");
		System.out.printf(marsrover.moving.getX() +" "+ marsrover.moving.getY() +" "+ marsrover.moving.getDirection());
	}

}
