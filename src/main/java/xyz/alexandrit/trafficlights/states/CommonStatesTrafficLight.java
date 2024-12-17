package xyz.alexandrit.trafficlights.states;

import xyz.alexandrit.trafficlights.SmartTrafficLight;
import xyz.alexandrit.trafficlights.TrafficLight;

public enum CommonStatesTrafficLight implements State<TrafficLight> {
    GREEN_TO_YELLOW("Green") {
        @Override
        public void next(TrafficLight trafficLight) {
            trafficLight.setState(YELLOW_TO_RED);
        }
    },
    YELLOW_TO_RED("Yellow") {
        @Override
        public void next(TrafficLight trafficLight) {
            trafficLight.setState(RED_TO_YELLOW);
        }
    },
    RED_TO_YELLOW("Red") {
        @Override
        public void next(TrafficLight trafficLight) {
            trafficLight.setState(YELLOW_TO_GREEN);
        }
    },
    YELLOW_TO_GREEN("Yellow") {
        @Override
        public void next(TrafficLight trafficLight) {
            trafficLight.setState(GREEN_TO_YELLOW);
        }
    };
    final String color;

    CommonStatesTrafficLight(String color) {
        this.color = color;
    }

    @Override
    public String color() {
        return color;
    }
}
