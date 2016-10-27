package com.github.vakhrymchuk.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

@SpringBootTest
public class BusRouteServiceImplTest extends AbstractTestNGSpringContextTests {

    @Autowired
    private BusRouteService busRouteService;

    @DataProvider
    public static Object[][] data() {
        return new Object[][]{
                {153, 150, true},
                {1, 99, false},
        };
    }

    @Test(dataProvider = "data")
    public void testDirect(final int depSid, final int arrSid, final boolean expected) throws Exception {
        assertEquals(busRouteService.direct(depSid, arrSid), expected);
    }

}