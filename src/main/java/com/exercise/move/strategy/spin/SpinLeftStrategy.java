package com.exercise.move.strategy.spin;

import com.exercise.model.Orientations;
import com.exercise.model.Rover;

public class SpinLeftStrategy implements SpinStrategy {
    @Override
    public void spin(Rover rover) {
        rover.setOrientation(Orientations.getPrevious(rover.getOrientation()));
    }
}
