/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu;

/**
 *
 * @author Sophie
 */
public class TrafficLight {
    SignalColor state = SignalColor.RED;

    public enum SignalColor {

        GREEN, YELLOW, RED
    }

    public void change(int numberOfTimes) {
        for (int i = 0; i < numberOfTimes; i++) {
            nextState();
        }
    }

    public void nextState() {
        switch (state) {
            case RED:
                state = SignalColor.GREEN;
                break;
            case YELLOW:
                state = SignalColor.RED;
                break;
            case GREEN:
                state = SignalColor.YELLOW;
                break;
            default:
                state = SignalColor.RED;
                break;
        }
    }
}
