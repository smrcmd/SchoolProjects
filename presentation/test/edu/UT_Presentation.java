package edu;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.IOException;
import java.util.Map;
import java.util.Properties;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import org.junit.Before;
import org.junit.Test;

/**
 *
 * @author Sophie
 */
public class UT_Presentation {

    private Presentation presentation;
    
    public UT_Presentation() {
    }

    @Before
    public void setUp() throws IOException {
        //presentation = new Presentation();
        //Properties loadProps = presentation.loadProperties();
        
    }
    
    @Test
    public void loadProperties_TestSize() throws IOException {
        presentation = new Presentation();
        Properties actualProperties = new Properties();
        actualProperties = presentation.loadProperties();
        assertEquals(4, actualProperties.size());
    }
    
    @Test
    public void loadProperties_TestContents() throws IOException {
        presentation = new Presentation();
        Properties actualProperties = new Properties();
        actualProperties = presentation.loadProperties();
        assertEquals("Camaro", actualProperties.getProperty("Bumblebee"));
    }
    
    @Test 
    public void capitalNames() {
        presentation = new Presentation();
        Map <String, String> actualValues = presentation.capitalNames();
        assertEquals("Albany", actualValues.get("New York"));
    }
    
    @Test
    public void sophie_testNotNull() {
        presentation = new Presentation();
        String actualValue = presentation.sophie();
        assertNotNull(actualValue);
    }
    
    private Properties testProps() {
        Properties testProps = new Properties();
        testProps.put("Optimus_Prime", "Peterbilt");
        testProps.put("Jazz", "Solstice");
        testProps.put("Bumblebee", "Camaro");
        testProps.put("Ratchet", "Hummer");
                
        return testProps;
    }
    
}
