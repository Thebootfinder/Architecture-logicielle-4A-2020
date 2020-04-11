package com.esiea.tp4A;
import static org.assertj.core.api.Assertions.assertThat;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class PositionPointTest {
    /* 
        TODO : 
    
        faire différents tests dans csvsource
        prendre en compte que quand on est à 50 et qu'on avance, on sera à -50 quand ce sera implémenté
    */
    @ParameterizedTest
    @CsvSource(value = {
        "0,0,1"
    })
    void is_X_incremented_correctly(int X, int Y, int X_expected) {
        PositionPoint point = new PositionPoint(X, Y);
        assertThat(point.getX_Forward()).isEqualTo(X_expected);
    }

    @ParameterizedTest
    @CsvSource(value = {
        "0,0,1"
    })
    void is_Y_incremented_correctly(int X, int Y, int Y_expected) {
        PositionPoint point = new PositionPoint(X, Y);
        assertThat(point.getY_Forward()).isEqualTo(Y_expected);
    }

    @ParameterizedTest
    @CsvSource(value = {
        "1,0,0"
    })
    void is_X_decremented_correctly(int X, int Y, int X_expected) {
        PositionPoint point = new PositionPoint(X, Y);
        assertThat(point.getX_Back()).isEqualTo(X_expected);
    }

    @ParameterizedTest
    @CsvSource(value = {
        "0,1,0"
    })
    void is_Y_decremented_correctly(int X, int Y, int Y_expected) {
        PositionPoint point = new PositionPoint(X, Y);
        assertThat(point.getY_Back()).isEqualTo(Y_expected);
    }

    @ParameterizedTest
    @CsvSource(value = {
        "0,0,0"
    })
    void is_X_well_recovered(int X, int Y, int X_expected) {
        PositionPoint point = new PositionPoint(X, Y);
        assertThat(point.getX()).isEqualTo(X_expected);
    }

    @ParameterizedTest
    @CsvSource(value = {
        "0,0,0"
    })
    void is_Y_well_recovered(int X, int Y, int Y_expected) {
        PositionPoint point = new PositionPoint(X, Y);
        assertThat(point.getY()).isEqualTo(Y_expected);
    }
}
