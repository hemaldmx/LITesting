package com.leadgain.gui.testng;



import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;


public class TestNGBase {

    public static long getTestRunTime() {
      return 0;
    }

    @BeforeSuite(alwaysRun = true)
    public static void setUp() throws Exception {

    }

    @AfterSuite(alwaysRun = true)
    public static void tearDown() {

    }
}