package com.exercise.util;

import com.exercise.model.Orientation;
import com.exercise.model.Position;
import com.exercise.model.Rover;
import org.junit.Test;

import static org.junit.Assert.*;

public class RoverUtilTest {

    @Test
    public void buildFromString() {
    }

    @Test
    public void buildFromString_should_return_a_rover() {
        String roverData = "5 6 N";
        Rover rover = RoverUtil.buildFromString(roverData);

        assertNotNull(roverData);
        assertEquals(5, rover.getPosition().getX());
        assertEquals(6, rover.getPosition().getY());
        assertEquals(Orientation.NORTH, rover.getOrientation());
    }

    @Test
    public void buildFromString_should_return_null_if_arguments_are_missing() {
        String roverData = "5 6";
        Rover rover = RoverUtil.buildFromString(roverData);

        assertNull(rover);
    }

    @Test
    public void buildFromString_should_return_null_if_arguments_are_incorrect() {
        String roverData = "5 6 7";
        Rover rover = RoverUtil.buildFromString(roverData);

        assertNull(rover);
    }

    @Test
    public void isOutOfRange_should_return_true() {
        Position upperRightPosition = new Position(5, 5);
        Rover rover = new Rover.RoverBuilder()
                .setPosition(new Position(6, 5))
                .build();

        assertTrue(RoverUtil.isOutOfRange(rover, upperRightPosition));
    }

    @Test
    public void isOutOfRange_should_return_false() {
        Position upperRightPosition = new Position(5, 5);
        Rover rover = new Rover.RoverBuilder()
                .setPosition(new Position(5, 5))
                .build();

        assertFalse(RoverUtil.isOutOfRange(rover, upperRightPosition));
    }
}