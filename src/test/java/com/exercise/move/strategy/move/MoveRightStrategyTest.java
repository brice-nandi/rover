package com.exercise.move.strategy.move;

import com.exercise.model.Orientation;
import com.exercise.model.Position;
import com.exercise.model.Rover;
import org.junit.Assert;
import org.junit.Test;

public class MoveRightStrategyTest {

    @Test
    public void move_should_increase_x_coordinate_by_1() {
        Position limit = new Position(5, 5);
        int originalX = 2;
        int originalY = 2;

        Rover rover = new Rover.RoverBuilder()
                .setOrientation(Orientation.SOUTH)
                .setPosition(new Position(originalX, originalY))
                .build();

        MoveStrategy moveStrategy = new MoveRightStrategy();
        moveStrategy.move(rover, limit);

        Assert.assertEquals(originalY, rover.getPosition().getY());
        Assert.assertEquals(3, rover.getPosition().getX());
    }

    @Test
    public void move_should_not_change_rover_position() {
        Position limit = new Position(5, 5);
        int originalX = 5;
        int originalY = 2;

        Rover rover = new Rover.RoverBuilder()
                .setOrientation(Orientation.SOUTH)
                .setPosition(new Position(originalX, originalY))
                .build();

        MoveStrategy moveStrategy = new MoveRightStrategy();
        moveStrategy.move(rover, limit);

        Assert.assertEquals(originalX, rover.getPosition().getX());
        Assert.assertEquals(originalY, rover.getPosition().getY());
    }
}