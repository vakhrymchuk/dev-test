package com.github.vakhrymchuk.service;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class BusRouteServiceImplTest {

    private BusRouteService busRouteService = new BusRouteServiceImpl();

    @DataProvider
    public static Object[][] data() {
        return new Object[][]{
                {1, 153, true}
        };
    }

    @Test(dataProvider = "data")
    public void testDirect(final int depSid, final int arrSid, final boolean expected) throws Exception {
        assertEquals(busRouteService.direct(depSid, arrSid), expected);
    }

}