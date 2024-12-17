package xyz.alexandrit.trafficlights.states;


import xyz.alexandrit.trafficlights.TrafficLight;

public interface State<T extends  TrafficLight> {
    void next(T trafficLight);
    String color();
}