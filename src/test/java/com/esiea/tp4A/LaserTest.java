package com.esiea.tp4A;




import com.esiea.tp4A.domain.Direction;

import com.esiea.tp4A.domain.Position;

import org.junit.jupiter.api.Test;

import org.junit.jupiter.params.ParameterizedTest;

import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;




import java.awt.*;




import static com.esiea.tp4A.domain.Direction.NORTH;

import static org.junit.jupiter.api.Assertions.*;




public class LaserTest {

    public final Mars mars = new Mars(  100);

    Laser laser = new Laser(mars, 5);




    @ParameterizedTest

    @CsvSource({

        "0, 0, 2, 0, NORTH, EAST,5, False, True",

        "0, 0, 5, 0, NORTH, EAST,5, False, True",

        "0, 0, 6, 0, NORTH, EAST,5, True, True",

        "0, 0, 2, 1, NORTH, EAST,5, True, True"

    })




    void shotEAST(int rovX, int rovY, int obsX, int obsY, Direction direction, Direction directionShoot, int range, boolean expectedIsObstacle, boolean expectedIsObstacle2){

        Moving mov = new Moving(new PositionPoint(rovX, rovY,mars), NORTH);

        laser.setRange(range);

        mars.obstaclePositions().add(new Position.FixedPosition(obsX,obsY,direction));

        mars.obstaclePositions().add(new Position.FixedPosition(obsX+1,obsY,direction));

        laser.shot(directionShoot, mov);

        assertThat(mars.IsObstacleThere(obsX, obsY)).isEqualTo(expectedIsObstacle);

        assertThat(mars.IsObstacleThere(obsX+1, obsY)).isEqualTo(expectedIsObstacle2);

    }




    @ParameterizedTest

    @CsvSource({

        "0, 0, -2, 0, NORTH, WEST,5, False, True",

        "0, 0, -5, 0, NORTH, WEST,5, False, True",

        "0, 0, -6, 0, NORTH, WEST,5, True, True",

        "0, 0, -2, 1, NORTH, WEST,5, True, True"

    })




    void shotWEST(int rovX, int rovY, int obsX, int obsY, Direction direction, Direction directionShoot,int range, boolean expectedIsObstacle, boolean expectedIsObstacle2){

        Moving mov = new Moving(new PositionPoint(rovX, rovY,mars), NORTH);

        laser.setRange(range);

        mars.obstaclePositions().add(new Position.FixedPosition(obsX,obsY,direction));

        mars.obstaclePositions().add(new Position.FixedPosition(obsX-1,obsY,direction));

        laser.shot(directionShoot, mov);

        assertThat(mars.IsObstacleThere(obsX, obsY)).isEqualTo(expectedIsObstacle);

        assertThat(mars.IsObstacleThere(obsX-1, obsY)).isEqualTo(expectedIsObstacle2);

    }




    @ParameterizedTest

    @CsvSource({

        "0, 0, 0, 2, NORTH, NORTH,5, False, True",

        "0, 0, 0, 5, NORTH, NORTH,5, False, True",

        "0, 0, 0, 6, NORTH, NORTH,5, True, True",

        "0, 0, 1, 2, NORTH, NORTH,5, True, True",

    })

    void shotNORTH(int rovX, int rovY, int obsX, int obsY, Direction direction, Direction directionShoot,int range, boolean expectedIsObstacle, boolean expectedIsObstacle2){

        Moving mov = new Moving(new PositionPoint(rovX, rovY,mars), NORTH);

        laser.setRange(range);

        mars.obstaclePositions().add(new Position.FixedPosition(obsX,obsY,direction));

        mars.obstaclePositions().add(new Position.FixedPosition(obsX,obsY+1,direction));

        laser.shot(directionShoot, mov);

        assertThat(mars.IsObstacleThere(obsX, obsY)).isEqualTo(expectedIsObstacle);

        assertThat(mars.IsObstacleThere(obsX, obsY+1)).isEqualTo(expectedIsObstacle2);

    }


    @ParameterizedTest

    @CsvSource({

        "0, 0, 0, -2, NORTH, SOUTH,5, False, True",

        "0, 0, 0, -5, NORTH, SOUTH,5, False, True",

        "0, 0, 0, -6, NORTH, SOUTH,5, True, True",

        "0, 0, 1, -2, NORTH, SOUTH,5, True, True"

    })




    void shotSOUTH(int rovX, int rovY, int obsX, int obsY, Direction direction, Direction directionShoot,int range, boolean IsObstacle, boolean IsObstacle2){

        Moving mov = new Moving(new PositionPoint(rovX, rovY,mars), NORTH);

        laser.setRange(range);

        mars.obstaclePositions().add(new Position.FixedPosition(obsX,obsY,direction));

        mars.obstaclePositions().add(new Position.FixedPosition(obsX,obsY-1,direction));

        laser.shot(directionShoot, mov);

        assertThat(mars.IsObstacleThere(obsX, obsY)).isEqualTo(IsObstacle);

        assertThat(mars.IsObstacleThere(obsX, obsY-1)).isEqualTo(IsObstacle2);

    }




    @ParameterizedTest

    @CsvSource({

        "0,0,0,1,NORTH,5, 0",

        "0,0,0,5,NORTH,5, 0",

        "0,0,0,6,NORTH,5, 1",

        "0,0,0,1,SOUTH,100,0",

    })

    void destroyRov(int rov1X, int rov1Y, int rov2X, int rov2Y, Direction direction, int range, int expectedSize) {

        Moving mov1 = new Moving(new PositionPoint(rov1X, rov1Y,mars), NORTH);

        Moving mov2 = new Moving(new PositionPoint(rov2X, rov2Y,mars), NORTH);

        mars.addRov(new Rover(mov2, mars));

        laser.setRange(range);

        laser.shot(direction, mov1);

        assertThat(mars.getRov().size()).isEqualTo(expectedSize);

    }

}
