package xyz.alexandrit.trafficlights;

import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;
import xyz.alexandrit.attributes.Time;
import xyz.alexandrit.trafficlights.states.SmartStatesTrafficLight;

@Getter
@Setter
public class SmartTrafficLight extends TrafficLight {
    @NonNull
    Time time;

    public SmartTrafficLight() {
        state = SmartStatesTrafficLight.GREEN_TO_YELLOW;
        time = new Time(12, 0, 0);
    }
}
