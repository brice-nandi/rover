package com.exercise.move.strategy.move;

import com.exercise.model.Position;
import com.exercise.model.Rover;

public interface MoveStrategy {

    void move(Rover rover, Position limit);
}
