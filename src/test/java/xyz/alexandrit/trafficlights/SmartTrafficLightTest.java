package xyz.alexandrit.trafficlights;

import org.junit.jupiter.api.Test;
import xyz.alexandrit.attributes.Time;

import static org.junit.jupiter.api.Assertions.*;

class SmartTrafficLightTest {
    @Test
    void example_from_exercise_book() {
        SmartTrafficLight smartTrafficLight = new SmartTrafficLight();
        smartTrafficLight.next();
        smartTrafficLight.next();
        smartTrafficLight.next();
        smartTrafficLight.next();
        smartTrafficLight.next();
        smartTrafficLight.next();
        smartTrafficLight.next();
        System.out.println(new Time(3, 0, 0));
        smartTrafficLight.setTime(new Time(3, 0, 0));
        smartTrafficLight.next();
        smartTrafficLight.next();
        smartTrafficLight.next();
        smartTrafficLight.next();
        smartTrafficLight.next();

    }

}