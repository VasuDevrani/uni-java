# Traffic Light System Documentation

## Overview
The Traffic Light System is designed to manage traffic lights at multiple intersections using a multi-threaded approach in Java. Each intersection has its own set of traffic lights, and the system ensures that the traffic lights operate in a safe manner to prevent conflicts such as simultaneous green lights in conflicting directions.

## Package Structure
**Package Name:** trafficlight

**Files:**
- TrafficLightSystem.java: Contains the main method to run the traffic light system.
- Intersection.java: Represents an intersection and manages multiple traffic lights.
- TrafficLight.java: Represents a single traffic light and controls its state.
- LightState.java: Enum defining the possible states of a traffic light (RED, YELLOW, GREEN).

## Class Descriptions

### TrafficLightSystem
**Description:** Initializes and controls the operation of intersections in a continuous loop.

**Key Attributes:**
- NUM_INTERSECTIONS: The number of intersections in the system.
- NUM_LIGHTS_PER_INTERSECTION: The number of traffic lights per intersection.
- CYCLE_DURATION: Duration of each operation cycle in milliseconds.

**Behavior:**
- Initializes intersections and starts a thread for each intersection to manage its traffic lights.
- Each intersection operates independently in its own thread.

### Intersection
**Description:** Manages a set of traffic lights and ensures they operate safely.

**Key Attributes:**
- lights: Array of TrafficLight objects.

**Behavior:**
- operate(): Changes the state of each traffic light in the intersection.
- isSafe(): Checks if the intersection is in a safe state (at most one green light at any time).

### TrafficLight
**Description:** Represents a single traffic light and manages its state transitions.

**Key Attributes:**
- state: Current state of the traffic light (RED, YELLOW, GREEN).
- lock: A reentrant lock to ensure thread safety during state changes.

**Behavior:**
- changeState(): Changes the state of the traffic light based on its current state.
- getState(): Returns the current state of the traffic light.

### LightState
**Description:** Enum that defines the possible states of a traffic light.

**Values:**
- RED
- YELLOW
- GREEN

## Thread Safety
The system uses thread synchronization and locks to ensure that the traffic lights operate safely without data corruption:
- Each TrafficLight object uses a ReentrantLock to manage state changes safely across multiple threads.
- The Intersection class uses synchronized blocks to manage operations across multiple traffic lights and ensure that state changes do not lead to unsafe traffic conditions.

## Folder Structure
```bash
## Folder Structure
src/
└── main/
    └── java/
        └── com/
            └── trafficlight/
                ├── TrafficLightSystem.java
                ├── Intersection.java
                ├── TrafficLight.java
                └── LightState.java
└── pom.xml
```

## Compilation and Execution Steps

**Set Up Your Environment:**
- Ensure Java is installed on your system. Download from Oracle's website or use OpenJDK.
- Optionally, use an IDE like IntelliJ IDEA, Eclipse, or Visual Studio Code.

**Compile the Code:**
- Navigate to the project root directory.
- Compile and execute the Java Program:

```bash
mvn compile exec:java
```

**Note on Execution:**
- The system runs in an infinite loop. To stop, interrupt manually (e.g., Ctrl+C).
- Ensure the Java classpath is set correctly if there are class loading issues.

This comprehensive documentation provides all necessary details to understand, compile, and run the Traffic Light System effectively.
