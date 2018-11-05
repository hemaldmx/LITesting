package com.leadgain.testcase;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.springframework.boot.test.context.SpringBootTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import com.leadgain.config.LeadGainTestApplication;


@SpringBootTest(classes = LeadGainTestApplication.class, value="leadgain.properties", webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class DashboardTest extends AbstractTestNGSpringContextTests {

    @Test
    public void simpleTest() {
        Assert.assertEquals(1, 1, "Identity");
    }

}