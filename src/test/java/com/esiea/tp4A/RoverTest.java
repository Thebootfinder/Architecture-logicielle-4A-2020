package com.esiea.tp4A;

import com.esiea.tp4A.domain.Direction;
import static org.assertj.core.api.Assertions.assertThat;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class RoverTest {

    public final Mars mars = new Mars(100);
    @ParameterizedTest
    @CsvSource(value= {
        "0,0,NORTH,b,0,-1,NORTH",
        "0,0,NORTH,fflb,1,2,WEST",
        "0,0,NORTH,lbblffr,2,-2,WEST",
        "5,-3,WEST,ff,3,-3,WEST",
        "5,-3,WEST,lbblffr,7,-1,SOUTH",
        "0,0,NORTH,aff,0,2,NORTH",
        "0,0,NORTH,f f,0,2,NORTH",
        "0,0,NORTH,f\"f,0,2,NORTH",
        "20,49,WEST,ffrfflbrf,19,-48,NORTH",
        
    })
    void is_rover_moving_properly(int X, int Y, Direction direction, String commands, int X_expected, int Y_expected, Direction direction_expected) {
        Moving position = init(X,Y,direction, mars);
        Rover rover = new Rover(position, mars);
        rover.move(commands);
        assertThat(rover.getPosition().getX()).isEqualTo(X_expected);
        assertThat(rover.getPosition().getY()).isEqualTo(Y_expected);
        assertThat(rover.getPosition().getDirection()).isEqualTo(direction_expected);
    }

    private Moving init(int X, int Y, Direction direction, Mars mars) {
        PositionPoint point = new PositionPoint(X, Y, mars);
        return new Moving(point, direction);
    }
}
