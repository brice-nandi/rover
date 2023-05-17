package com.exercise.model;

import java.util.Arrays;
import java.util.List;

public class Orientations {

    private static final List<Orientation> items = Arrays.asList(Orientation.WEST, Orientation.NORTH, Orientation.EAST, Orientation.SOUTH);

    public static Orientation getPrevious(Orientation orientation) {
        if (Orientation.WEST == orientation) {
            return Orientation.SOUTH;
        }
        return items.get(items.indexOf(orientation) - 1);
    }

    public static Orientation getNext(Orientation orientation) {
        if (Orientation.SOUTH == orientation) {
            return Orientation.WEST;
        }
        return items.get(items.indexOf(orientation) + 1);
    }
}
