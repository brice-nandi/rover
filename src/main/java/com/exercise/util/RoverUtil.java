package com.exercise.util;

import com.exercise.model.Orientation;
import com.exercise.model.Position;
import com.exercise.model.Rover;

public class RoverUtil {


    public static Rover buildFromString(String line) {
        if (line != null) {
            String[] coordinatesData = line.split(" ");
            if (coordinatesData.length == 3) {
                //Parsing orientation
                Orientation orientation = Orientation.fromCode(coordinatesData[2]);
                if (Orientation.UNKNOWN == orientation) {
                    System.out.println("Invalid orientation: " + coordinatesData[2]);
                    return null;
                }

                //Parsing position
                Position position;
                try {
                    position = new Position(Integer.parseInt(coordinatesData[0]), Integer.parseInt(coordinatesData[1]));

                    return new Rover.RoverBuilder()
                            .setPosition(position)
                            .setOrientation(orientation)
                            .build();
                } catch (Exception e) {
                    System.out.println("Rover position data could not be parsed: " + coordinatesData[0] + " - " + coordinatesData[1]);
                }
            } else {
                System.out.println("Rover data is incorrect.");
            }
        }
        return null;
    }

    public static boolean isOutOfRange(Rover rover, Position upperRightPosition) {
        return rover.getPosition().getX() > upperRightPosition.getX()
                || rover.getPosition().getY() > upperRightPosition.getY();
    }
}
