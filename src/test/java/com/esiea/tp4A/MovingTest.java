package com.esiea.tp4A;

import com.esiea.tp4A.domain.Direction;
import static org.assertj.core.api.Assertions.assertThat;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;


public class MovingTest {


    @ParameterizedTest
    @CsvSource({
        "0, 0, NORTH, NORTH"
    })
    void did_rover_turn_left(int X, int Y, Direction direction, Direction direction_expected) {
        Moving position = initializing(X, Y, direction);
        assertThat(position.rotateLeft()).isEqualTo(direction_expected);
    }

    @ParameterizedTest
    @CsvSource({
        "0, 0, NORTH, NORTH"
    })
    void did_rover_turn_right(int X, int Y, Direction direction, Direction direction_expected) {
        Moving position = initializing(X, Y, direction);
        assertThat(position.rotateRight()).isEqualTo(direction_expected);
    }

    @ParameterizedTest
    @CsvSource({
        "0, 0, NORTH, 0, 0"
    })
    void did_rover_move_forward(int X, int Y, Direction direction, int X_expected, int Y_expected) {
        Moving position = initializing(X, Y, direction);
        position.goForward();
        assertThat(position.getX()).isEqualTo(X_expected);
        assertThat(position.getY()).isEqualTo(Y_expected);
    }

    @ParameterizedTest
    @CsvSource({
        "0, 0, NORTH, 0, 0"
    })
    void did_rover_move_back(int X, int Y, Direction direction, int X_expected, int Y_expected) {
        Moving position = initializing(X, Y, direction);
        /* TODO : modifier goForward en goBack lorsque goBack sera implémenté*/
        position.goForward();
        assertThat(position.getX()).isEqualTo(X_expected);
        assertThat(position.getY()).isEqualTo(Y_expected);
    }

    private Moving initializing(int X, int Y, Direction direction) {
        PositionPoint point = new PositionPoint(X, Y);
        Moving position = new Moving(point, direction);
        return position;
    }
}
