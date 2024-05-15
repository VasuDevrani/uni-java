package com.trafficlight;

public class Intersection {
    private final TrafficLight[] lights;

    public Intersection(int numLights) {
        lights = new TrafficLight[numLights];
        for (int i = 0; i < numLights; i++) {
            lights[i] = new TrafficLight();
        }
    }

    public void operate() {
        for (TrafficLight light : lights) {
            light.changeState();
        }
    }

    public boolean isSafe() {
        int greenCount = 0;
        for (TrafficLight light : lights) {
            if (light.getState() == LightState.GREEN) {
                greenCount++;
            }
        }
        return greenCount <= 1;
    }
}