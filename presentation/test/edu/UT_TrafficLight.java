/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu;

import edu.TrafficLight.SignalColor;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Sophie
 */
public class UT_TrafficLight {
    
    @Before
    public void setUp() {
    }

    @Test
    public void testNextState() {
    TrafficLight light = new TrafficLight();
    assertEquals(SignalColor.RED, light.state);
    light.nextState();
    assertEquals(SignalColor.GREEN, light.state);
    light.nextState();
    assertEquals(SignalColor.YELLOW, light.state);
    light.nextState();
    assertEquals(SignalColor.RED, light.state);
  }
 
  @Test
  public void testChange() {
    TrafficLight light = new TrafficLight();
    light.change(5);  
    assertEquals(SignalColor.YELLOW, light.state);
  }
}
