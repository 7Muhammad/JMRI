package jmri.jmrit.roster;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import jmri.util.JmriJFrame;

/**
 *
 * @author Paul Bender Copyright (C) 2017	
 */
public class FullBackupExportActionTest {

    @Test
    public void testCTor() {
        JmriJFrame jf = new JmriJFrame("TestFullBackupWindow");
        jmri.util.swing.WindowInterface wi = jf;
        FullBackupExportAction t = new FullBackupExportAction("test full backup export",wi);
        Assert.assertNotNull("exists",t);
        jf.dispose();
    }

    // The minimal setup for log4J
    @Before
    public void setUp() {
        apps.tests.Log4JFixture.setUp();
        jmri.util.JUnitUtil.resetInstanceManager();
    }

    @After
    public void tearDown() {
        jmri.util.JUnitUtil.resetInstanceManager();
        apps.tests.Log4JFixture.tearDown();
    }

    private final static Logger log = LoggerFactory.getLogger(FullBackupExportActionTest.class.getName());

}
