package com.esiea.tp4A;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import static org.assertj.core.api.Assertions.assertThat;

import com.esiea.tp4A.domain.Direction;
import com.esiea.tp4A.domain.Position;

public class ObstacleTest {

    public final Mars mars = new Mars(100);

    @ParameterizedTest
    @CsvSource({
        "6,6",
        "10,10",
        "119,119",
        "-6,0"
    })
    void is_number_of_obstacles_correct(int numberofObstacle,int expectedNumber){
        mars.geneObstacles(numberofObstacle);
        assertThat(mars.obstaclePositions().size()).isEqualTo(expectedNumber);
    }

    @ParameterizedTest
    @CsvSource({
        "1,1,1,1,true",
        "3,2,1,3,false",
        "0,0,0,0,true"
    })
    void is_obstacle_in_given_position(int xObs,int yObs,int XTest,int YTest,boolean ObstacleThere){
        mars.obstaclePositions().add(new Position.FixedPosition(xObs,yObs, Direction.NORTH));
        assertThat(mars.IsObstacleThere(XTest, YTest)).isEqualTo(ObstacleThere);
    }

}