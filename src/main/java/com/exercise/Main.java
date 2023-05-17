package com.exercise;

import com.exercise.model.Position;
import com.exercise.model.Rover;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Collection;

public class Main {
    public static void main(String[] args) {
        if (args.length < 1) {
            System.out.println("Please specify a file name");
            return;
        }

        String file = args[0];

        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            String firstLine = reader.readLine();
            if (firstLine != null) {
                Position upperRightPosition = getUpperRightPosition(firstLine);
                if (upperRightPosition == null) {
                    System.out.println("incorrect Upper right coordinates.");
                    System.out.println("ROVER is done;");
                    return;
                }

                Collection<Rover> rovers = RoverCommandProcessor.process(reader, upperRightPosition);

                rovers.forEach(System.out::println);

            }
        } catch (FileNotFoundException e) {
            System.out.println("File not found..");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }

    private static Position getUpperRightPosition(String firstLine) {
        String[] positionData = firstLine.split(" ");
        if (positionData.length == 2 ) {
            try {
                return new Position(Integer.parseInt(positionData[0]), Integer.parseInt(positionData[1]));
            } catch (Exception e) {
                System.out.println("Upper right coordinates could not be parsed.");
            }
        }
        return null;
    }
}