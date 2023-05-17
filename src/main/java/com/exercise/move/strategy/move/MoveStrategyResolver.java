package com.exercise.move.strategy.move;

import com.exercise.model.Orientation;

import java.util.HashMap;
import java.util.Map;

public class MoveStrategyResolver {

    private final Map<Orientation, MoveStrategy> strategyMap = new HashMap<>();
    private static MoveStrategyResolver instance;

    private MoveStrategyResolver() {
        initMap();
    }

    public static MoveStrategyResolver getInstance() {
        if (instance == null) {
            instance = new MoveStrategyResolver();
        }

        return instance;
    }

    private void initMap() {
        strategyMap.put(Orientation.SOUTH, new MoveDownStrategy());
        strategyMap.put(Orientation.EAST, new MoveRightStrategy());
        strategyMap.put(Orientation.NORTH, new MoveUpStrategy());
        strategyMap.put(Orientation.WEST, new MoveLeftStrategy());
    }

    public MoveStrategy resolve(Orientation orientation) {
        return strategyMap.get(orientation);
    }
}
