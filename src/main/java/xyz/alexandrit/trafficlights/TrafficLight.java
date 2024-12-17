package xyz.alexandrit.trafficlights;

import lombok.Setter;
import xyz.alexandrit.trafficlights.states.CommonStatesTrafficLight;
import xyz.alexandrit.trafficlights.states.State;

@Setter
public class TrafficLight {
    protected State state;

    public TrafficLight() {
        state = CommonStatesTrafficLight.GREEN_TO_YELLOW;
    }

    void next() {
        System.out.println(state.color());
        state.next(this);
    }

}
