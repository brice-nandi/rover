package com.exercise.move.strategy.move;

import com.exercise.model.Position;
import com.exercise.model.Rover;

public class MoveLeftStrategy implements MoveStrategy{
    @Override
    public void move(Rover rover, Position limit) {
        if (rover.getPosition().getX() > 0) {
            rover.getPosition().setX(rover.getPosition().getX() - 1);
        }
    }
}
