package jmri.jmrit.timetable;

import org.junit.*;

/**
 * Tests for the Layout Class
 * @author Dave Sand Copyright (C) 2018
 */
public class LayoutTest {

    @Test
    public void testCreate() {
        new Layout();
    }

    @Test
    public void testSettersAndGetters() {
        Layout layout = new Layout();
        Assert.assertNotNull(layout);
        layout.setLayoutName("Test Name");  // NOI18N
        Assert.assertEquals("Test Name", layout.getLayoutName());  // NOI18N
        Assert.assertEquals("HO", layout.getScale());  // NOI18N
        try {
            layout.setFastClock(0);
        } catch (IllegalArgumentException ex) {
            Assert.assertEquals(ex.getMessage(), "FastClockLt1");  // NOI18N
        }
        try {
            layout.setFastClock(100);
        } catch (IllegalArgumentException ex) {
            Assert.assertEquals(ex.getMessage(), "TimeOutOfRange");  // NOI18N
        }
        layout.setFastClock(6);
        Assert.assertEquals(6, layout.getFastClock());
        Assert.assertTrue(layout.getRatio() > 0.0f);
        try {
            layout.setScale("XY");
        } catch (IllegalArgumentException ex) {
            Assert.assertEquals(ex.getMessage(), "ScaleNotFound~XY");  // NOI18N
        }
        try {
            layout.setThrottles(-2);
        } catch (IllegalArgumentException ex) {
            Assert.assertEquals(ex.getMessage(), "ThrottlesLt0");  // NOI18N
        }
        layout.setThrottles(3);
        Assert.assertEquals(3, layout.getThrottles());
        layout.setMetric(true);
        Assert.assertTrue(layout.getMetric());
        layout.setScaleMK();
        Assert.assertEquals(1.914, layout.getScaleMK(), .1);
        Assert.assertEquals("Test Name", layout.toString());  // NOI18N
    }

    @Before
    public void setUp() {
        jmri.util.JUnitUtil.setUp();
    }

    @After
    public void tearDown() {
        jmri.util.JUnitUtil.tearDown();
    }
//     private final static org.slf4j.Logger log = org.slf4j.LoggerFactory.getLogger(LayoutTest.class);
}