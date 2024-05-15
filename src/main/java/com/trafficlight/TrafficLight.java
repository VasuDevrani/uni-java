package com.trafficlight;

import java.util.concurrent.locks.ReentrantLock;

public class TrafficLight {
    private LightState state;
    private final ReentrantLock lock;

    public TrafficLight() {
        state = LightState.RED;
        lock = new ReentrantLock();
    }

    public void changeState() {
        lock.lock();
        try {
            switch (state) {
                case RED:
                    state = LightState.GREEN;
                    break;
                case YELLOW:
                    state = LightState.RED;
                    break;
                case GREEN:
                    state = LightState.YELLOW;
                    break;
            }
        } finally {
            lock.unlock();
        }
    }

    public LightState getState() {
        return state;
    }
}