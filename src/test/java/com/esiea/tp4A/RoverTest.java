package com.esiea.tp4A;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import static org.assertj.core.api.Assertions.assertThat;
import com.esiea.tp4A.domain.*;

public class RoverTest {

    @ParameterizedTest
    @CsvSource({
        "0, 0, NORTH, fbrl, 0, 0, NORTH"
    })
    void is_rover_moved_correctly(int X, int Y, Direction direction, String commands, int X_expected, int Y_expected, Direction direction_expected) {
        Rover rover = initializing(X, Y, direction);
        rover.move(commands);
        /* TODO : à implémenter */
    }

    private Rover initializing(int X, int Y, Direction direction) {
        PositionPoint point = new PositionPoint(X, Y);
        Moving position = new Moving(point, direction);
        Rover rover = new Rover(position);
        return rover;
    }
}
