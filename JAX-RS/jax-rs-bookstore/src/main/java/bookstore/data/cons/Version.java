/*
 * @Copyright DTI 2016
 * All Rights Reserved
 */

package bookstore.data.cons;

/**
 * <p>
 * Representation of Application Version.
 * </p>
 * 
 * @since June 16, 2016
 */
public class Version {
    private String buildNumber;
    private String displayName;
    
    public Version() {}

    public Version(String buildNumber, String displayName) {
        this.buildNumber = buildNumber;
        this.displayName = displayName;
    }

    public String getBuildNumber() {
        return buildNumber;
    }

    public void setBuildNumber(String buildNumber) {
        this.buildNumber = buildNumber;
    }

    public String getDisplayName() {
        return displayName;
    }

    public void setDisplayName(String displayName) {
        this.displayName = displayName;
    }
}
