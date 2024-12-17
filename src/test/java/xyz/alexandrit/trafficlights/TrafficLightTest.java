package xyz.alexandrit.trafficlights;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TrafficLightTest {
    @Test
    void test_from_exercise_book() {
        TrafficLight tf = new TrafficLight();
        tf.next();
        tf.next();
        tf.next();
        tf.next();
        tf.next();
    }

}