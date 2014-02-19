/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package view;

import main.Session;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Florentijn
 */
public class OverviewTest {
    
    public OverviewTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of getMyInfo method, of class Overview.
     */
    @Test
    public void testGetMyInfo() throws Exception {
        System.out.println("getMyInfo");
        Session.setCurrentServerIp("127.0.0.1");
        Session.setCurrentServerPort(1226);
        Session.setCurrentUsername("easypmd");
        Session.setCurrentPassword("panda"); //"easytest"
        Overview instance = new Overview();
//        instance.getMyInfo();
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }   
}