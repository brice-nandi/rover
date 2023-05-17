package com.exercise.move.strategy.spin;

import com.exercise.model.SpinType;

import java.util.HashMap;
import java.util.Map;

public class SpinStrategySolver {

    private final Map<SpinType, SpinStrategy> strategyMap = new HashMap<>();
    private static SpinStrategySolver instance;

    private SpinStrategySolver() {
        initMap();
    }

    public static SpinStrategySolver getInstance() {
        if (instance == null) {
            instance = new SpinStrategySolver();
        }

        return instance;
    }

    private void initMap() {
        strategyMap.put(SpinType.LEFT, new SpinLeftStrategy());
        strategyMap.put(SpinType.RIGHT, new SpinRightStrategy());
    }

    public SpinStrategy resolve(SpinType spinType) {
        return strategyMap.get(spinType);
    }
}
