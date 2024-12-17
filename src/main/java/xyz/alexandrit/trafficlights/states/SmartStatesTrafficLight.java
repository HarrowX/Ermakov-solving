package xyz.alexandrit.trafficlights.states;

import xyz.alexandrit.attributes.Time;
import xyz.alexandrit.trafficlights.SmartTrafficLight;
import xyz.alexandrit.trafficlights.TrafficLight;

public enum SmartStatesTrafficLight implements State<SmartTrafficLight> {
    GREEN_TO_YELLOW("Green") {
        @Override
        public void next(SmartTrafficLight trafficLight) {
            setState(trafficLight, YELLOW_TO_RED);
        }
    },
    YELLOW_TO_RED("Yellow") {
        @Override
        public void next(SmartTrafficLight trafficLight) {
            setState(trafficLight, RED_TO_YELLOW);
        }
    },
    RED_TO_YELLOW("Red") {
        @Override
        public void next(SmartTrafficLight trafficLight) {
            setState(trafficLight, YELLOW_TO_GREEN);
        }
    },
    YELLOW_TO_GREEN("Yellow") {
        @Override
        public void next(SmartTrafficLight trafficLight) {
            setState(trafficLight, GREEN_TO_YELLOW);
        }
    };
    final String color;

    SmartStatesTrafficLight(String color) {
        this.color = color;
    }


    void setState(SmartTrafficLight trafficLight, State<SmartTrafficLight> stateTrafficLight) {
        if (trafficLight.getTime().compareTo(new Time(5,0,0)) <= 0) {
            trafficLight.setState(GREEN_TO_YELLOW);
            return;
        }
        trafficLight.setState(stateTrafficLight);
    }
    public String color() {
        return color;
    }
}
