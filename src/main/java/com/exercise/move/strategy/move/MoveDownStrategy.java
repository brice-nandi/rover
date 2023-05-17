package com.exercise.move.strategy.move;

import com.exercise.model.Position;
import com.exercise.model.Rover;

public class MoveDownStrategy implements MoveStrategy{
    @Override
    public void move(Rover rover, Position limit) {
        if (rover.getPosition().getY() > 0) {
            rover.getPosition().setY(rover.getPosition().getY() - 1);
        }
    }
}
