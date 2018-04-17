/*
 * @Copyright DTI 2016
 * All Rights Reserved
 */

package bookstore.services.util;

import bookstore.data.cons.Version;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * <p>
 * Utility Class for Loading the Application Version.
 * </p>
 * 
 * @since June 16, 2016
 */
public abstract class VersionUtil {
    private static final Version VERSION;
    
    static {
        InputStream instr = VersionUtil.class.getClassLoader()
                .getResourceAsStream("application.config.properties");
        Properties prop = new Properties();
        
        try {
            prop.load(instr);
            
            VERSION = new Version(prop.getProperty("app.version", ""), 
                    prop.getProperty("app.display.name", ""));
        } catch (IOException e) {
            throw new ExceptionInInitializerError("Failed to load "
                    + "'application.config.properties'. " + e.getMessage());
        }
    }
    
    public static Version getVersion() {
        return VERSION;
    }
}
