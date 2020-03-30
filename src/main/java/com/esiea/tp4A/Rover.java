package com.esiea.tp4A;

import com.esiea.tp4A.domain.*;

public class Rover implements MarsRover {

	public Position position;
	public Moving moving;
	
	public Rover(Moving moving) {
		this.moving = moving;
	}
	
	//retourne la position apres la ligne de commande
	@Override
	public Position move(String command) {
        for(char c : command.toCharArray()) {
        	analyse(c);
        }
        return position;
    }
	
	public void analyse(char command) {
		switch (command) {
		case 'f': moving.go_forward(); break;
		case 'b': moving.go_back(); break;
		case 'l': moving.rotate_left(); break;
		case 'r': moving.rotate_right(); break;
		default : System.err.print("Mauvaise touche"); break;
		}
	}

}
