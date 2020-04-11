package com.esiea.tp4A;

import com.esiea.tp4A.domain.Direction;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import static org.assertj.core.api.Assertions.assertThat;

public class MovingTest {
	@ParameterizedTest
    @CsvSource(value = {
        "0,0,NORTH,WEST",
        "0,0,WEST,SOUTH",
        "0,0,SOUTH,EAST",
        "0,0,EAST,NORTH"
    })
    void does_rover_rotate_left(int X, int Y, Direction direction, Direction direction_expected) {
        Moving position = init(X,Y,direction);
        assertThat(position.rotateLeft()).isEqualTo(direction_expected);
    }

    @ParameterizedTest
    @CsvSource(value = {
        "0,0,NORTH,EAST",
        "0,0,EAST,SOUTH",
        "0,0,SOUTH,WEST",
        "0,0,WEST,NORTH"
    })
    void does_rover_rotate_right(int X, int Y, Direction direction, Direction direction_expected) {
        Moving position = init(X,Y,direction);
        assertThat(position.rotateRight()).isEqualTo(direction_expected);
    }

    /* 
        TODO : 
    
        faire différents tests dans csvsource
        prendre en compte que quand on est à 50 et qu'on avance, on sera à -50 quand ce sera implémenté
    */
    @ParameterizedTest
    @CsvSource(value = {
        "0,0,NORTH,0,1",
        "0,0,EAST,1,0",
        "0,0,SOUTH,0,-1",
        "0,0,WEST,-1,0",
    })
    void does_rover_move_forward(int X, int Y, Direction direction, int X_expected, int Y_expected) {
        Moving position = init(X,Y,direction);
        position.goForward();
        assertThat(position.getX()).isEqualTo(X_expected);
        assertThat(position.getY()).isEqualTo(Y_expected);
    }

    /* 
        TODO : 
    
        faire différents tests dans csvsource
        prendre en compte que quand on est à 50 et qu'on avance, on sera à -50 quand ce sera implémenté
    */
    @ParameterizedTest
    @CsvSource(value = {
        "0,0,NORTH,0,-1",
        "0,0,EAST,-1,0",
        "0,0,SOUTH,0,1",
        "0,0,WEST,1,0"
    })
    void does_rover_move_back(int X, int Y, Direction direction, int X_expected, int Y_expected) {
        Moving position = init(X,Y,direction);
        position.goBackward();
        assertThat(position.getX()).isEqualTo(X_expected);
        assertThat(position.getY()).isEqualTo(Y_expected);
    }

    private Moving init(int X, int Y, Direction direction) {
        PositionPoint point = new PositionPoint(X, Y);
        return new Moving(point, direction);
    }
}
