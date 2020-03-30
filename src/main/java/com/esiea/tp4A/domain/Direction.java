package com.esiea.tp4A.domain;

import com.esiea.tp4A.Rotation;

public enum Direction implements Rotation {
	NORTH {
		@Override
		public Direction rotateLeft() {
			return WEST;
		}
		
		@Override
		public Direction rotateRight() {
			return EAST;
		}
	},
	
	EAST {
		@Override
		public Direction rotateLeft() {
			return NORTH;
		}
		
		@Override
		public Direction rotateRight() {
			return SOUTH;
		}
	},
	
	SOUTH {
		@Override
		public Direction rotateLeft() {
			return EAST;
		}
		
		@Override
		public Direction rotateRight() {
			return WEST;
		}
	},
	
	WEST {
		@Override
		public Direction rotateLeft() {
			return SOUTH;
		}
		
		@Override
		public Direction rotateRight() {
			return NORTH;
		}
	};
}
