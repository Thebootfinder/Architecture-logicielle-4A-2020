package com.esiea.tp4A;

import com.esiea.tp4A.domain.*;

public class NotreMarsRover implements MarsRover {
	
	public NotreMarsRover(Position position) {
		this.position = position;
	}

	public Position position;
	public Moving moving;
	
	//retourne la position apres la ligne de commande
	@Override
	public Position move(String command) {
        for(char c : command.toCharArray()) {
        	moving = new Moving(c, position);
        	position = moving.analyse(c);
        }
        return position;
    }

}
