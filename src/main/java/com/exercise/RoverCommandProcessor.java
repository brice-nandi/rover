package com.exercise;

import com.exercise.model.Position;
import com.exercise.model.Rover;
import com.exercise.model.SpinType;
import com.exercise.move.MoveCommand;
import com.exercise.move.strategy.move.MoveStrategy;
import com.exercise.move.strategy.move.MoveStrategyResolver;
import com.exercise.move.strategy.spin.SpinStrategy;
import com.exercise.move.strategy.spin.SpinStrategySolver;
import com.exercise.util.RoverUtil;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;

public class RoverCommandProcessor {
    public static Collection<Rover> process(BufferedReader reader, Position upperRightPosition) {
        Collection<Rover> rovers = new ArrayList<>();
        String line;
        try {
            while ((line = reader.readLine()) != null) {
                Rover rover = RoverUtil.buildFromString(line);

                line = reader.readLine();
                if (rover == null) {
                    System.out.println("No rover could be parsed from line " + line);
                } else if (RoverUtil.isOutOfRange(rover, upperRightPosition)) {
                    System.out.println("The rover is out of range: " + rover);
                } else {
                    computeRoverMoveCommand(rover, line, upperRightPosition);
                    rovers.add(rover);
                }

            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        return rovers;
    }

    private static void computeRoverMoveCommand(Rover rover, String line, Position upperRightPosition) {
        if (line == null || line.isEmpty()) {
            System.out.println("There is no move command to process");
            return;
        }

        for (String command : line.split("")) {
            processCommand(command, rover, upperRightPosition);
        }
    }

    private static void processCommand(String command, Rover rover, Position upperRightPosition) {
        switch (command) {
            case MoveCommand.MOVE_FORWARD:
                MoveStrategy moveStrategy = MoveStrategyResolver.getInstance().resolve(rover.getOrientation());
                if (moveStrategy != null) {
                    moveStrategy.move(rover, upperRightPosition);
                }

            break;
            case MoveCommand.ROTATE_RIGHT:
            case MoveCommand.ROTATE_LEFT:
                SpinStrategy spinStrategy = SpinStrategySolver.getInstance().resolve(SpinType.fromCode(command));
                if (spinStrategy != null) {
                    spinStrategy.spin(rover);
                }
                break;

            default:
                System.out.println("Command unknown: " + command);
        }
    }

}
