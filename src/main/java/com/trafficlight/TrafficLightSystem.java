package com.trafficlight;

public class TrafficLightSystem {
    private static final int NUM_INTERSECTIONS = 4;
    private static final int NUM_LIGHTS_PER_INTERSECTION = 2;
    private static final int CYCLE_DURATION = 5000; // 5 seconds

    public static void main(String[] args) {
        Intersection[] intersections = new Intersection[NUM_INTERSECTIONS];
        for (int i = 0; i < NUM_INTERSECTIONS; i++) {
            intersections[i] = new Intersection(NUM_LIGHTS_PER_INTERSECTION);
        }

        int cycleCount = 1;
        while (true) {
            System.out.println("Cycle " + cycleCount + " started.");

            for (int i = 0; i < intersections.length; i++) {
                final int intersectionIndex = i;
                Thread thread = new Thread(() -> {
                    synchronized (intersections[intersectionIndex]) {
                        intersections[intersectionIndex].operate();
                        while (!intersections[intersectionIndex].isSafe()) {
                            try {
                                intersections[intersectionIndex].wait();
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }
                        }
                        intersections[intersectionIndex].notifyAll();
                    }
                    System.out.println("Intersection " + intersectionIndex + " updated.");
                });
                thread.start();
            }

            try {
                Thread.sleep(CYCLE_DURATION);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            System.out.println("Cycle " + cycleCount + " completed.");
            cycleCount++;
        }
    }
}
