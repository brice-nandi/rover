package com.exercise.move.strategy.move;

import com.exercise.model.Orientation;
import com.exercise.model.Position;
import com.exercise.model.Rover;
import org.junit.Assert;
import org.junit.Test;

public class MoveDownStrategyTest {

    @Test
    public void move_should_decrease_y_coordinate_by_1() {
        Position limit = new Position(5, 5);
        int originalX = 2;
        int originalY = 2;

        Rover rover = new Rover.RoverBuilder()
                .setOrientation(Orientation.SOUTH)
                .setPosition(new Position(originalX, originalY))
                .build();

        MoveStrategy moveStrategy = new MoveDownStrategy();
        moveStrategy.move(rover, limit);

        Assert.assertEquals(originalX, rover.getPosition().getX());
        Assert.assertEquals(1, rover.getPosition().getY());
    }

    @Test
    public void move_should_not_change_rover_position() {
        Position limit = new Position(5, 5);
        int originalX = 2;
        int originalY = 0;

        Rover rover = new Rover.RoverBuilder()
                .setOrientation(Orientation.SOUTH)
                .setPosition(new Position(originalX, originalY))
                .build();

        MoveStrategy moveStrategy = new MoveDownStrategy();
        moveStrategy.move(rover, limit);

        Assert.assertEquals(originalX, rover.getPosition().getX());
        Assert.assertEquals(originalY, rover.getPosition().getY());
    }

}