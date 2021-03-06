package com.esiea.tp4A;


import com.esiea.tp4A.domain.Direction;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import static org.assertj.core.api.Assertions.assertThat;

public class MovingTest {

    public final Mars mars = new Mars(100);

	@ParameterizedTest
    @CsvSource(value = {
        "0,0,NORTH,WEST",
        "0,0,WEST,SOUTH",
        "0,0,SOUTH,EAST",
        "0,0,EAST,NORTH",

    })
    void does_rover_rotate_left(int X, int Y, Direction direction, Direction direction_expected) {
        Moving position = init(X,Y,direction, mars);
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
        Moving position = init(X,Y,direction, mars);
        assertThat(position.rotateRight()).isEqualTo(direction_expected);
    }

    @ParameterizedTest
    @CsvSource(value = {
    
        "0,0,NORTH,0,1",
        "0,0,EAST,1,0",
        "0,0,SOUTH,0,-1",
        "0,0,WEST,-1,0",
        "0,50,NORTH,0,-49",
        "50,0,EAST,-49,0",
        "0,-49,SOUTH,0,50",
        "-49,0,WEST,50,0"
        
    })
    void does_rover_move_forward(int X, int Y, Direction direction, int X_expected, int Y_expected) {
        Moving position = init(X,Y,direction, mars);
        position.goForward();
        assertThat(position.getX()).isEqualTo(X_expected);
        assertThat(position.getY()).isEqualTo(Y_expected);
    }

    @ParameterizedTest
    @CsvSource(value = {
        "0,0,NORTH,0,-1",
        "0,0,EAST,-1,0",
        "0,0,SOUTH,0,1",
        "0,0,WEST,1,0",
        "0,-49,NORTH,0,50",
        "-49,0,EAST,50,0",
        "0,50,SOUTH,0,-49",
        "50,0,WEST,-49,0"
    })
    void does_rover_move_back(int X, int Y, Direction direction, int X_expected, int Y_expected) {
        Moving position = init(X,Y,direction, mars);
        position.goBackward();
        assertThat(position.getX()).isEqualTo(X_expected);
        assertThat(position.getY()).isEqualTo(Y_expected);
    }

    private Moving init(int X, int Y, Direction direction, Mars mars) {
        PositionPoint point = new PositionPoint(X, Y, mars);
        return new Moving(point, direction);
    }
}
