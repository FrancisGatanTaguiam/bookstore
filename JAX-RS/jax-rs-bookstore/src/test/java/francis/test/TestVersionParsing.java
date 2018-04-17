/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package francis.test;

import bookstore.data.cons.Version;
import bookstore.services.util.VersionUtil;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 *
 * @author ldmalafo
 */
public class TestVersionParsing {
    private static Logger LOG;
    
    public TestVersionParsing() {
    }
    
    @BeforeClass
    public static void setUpClass() {
        LOG = LoggerFactory.getLogger(TestVersionParsing.class);
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
        LOG.info("Starting Testing of Version Parsing.");
    }
    
    @After
    public void tearDown() {
        LOG.info("Completed Testing of Version parsing.");
    }

    @Test
    public void testVersionParsing() {
        LOG.debug("Executing testVersionParsing().");
        
        Version version = VersionUtil.getVersion();
        
        assertNotNull("Version Cannot be NULL", version);
        assertNotNull("Build Number Cannot be NULL", version.getBuildNumber());
        assertNotNull("Display Name Cannot be NULL", version.getDisplayName());
        assertFalse("Build Number Cannot be Empty", version.getBuildNumber().trim().isEmpty());
        assertFalse("Display Name Cannot be NULL", version.getDisplayName().trim().isEmpty());
        
        LOG.debug("Build Number: '{}'", version.getBuildNumber());
        LOG.debug("Display Name: '{}'", version.getDisplayName());
    }
}
