/*
 * @Copyright DTI 2016
 * All Rights Reserved
 */

package bookstore.services;

import java.util.Set;
import javax.ws.rs.core.Application;

/**
 *
 * @author Lorenzo D. Malafo Jr.
 * @since June 16, 2016
 */
@javax.ws.rs.ApplicationPath("ws")
public class ApplicationConfig extends Application {

@Override
    public Set<Class<?>> getClasses() {
        Set<Class<?>> resources = new java.util.HashSet<>();
        addRestResourceClasses(resources);
        return resources;
    }

    /**
     * Do not modify addRestResourceClasses() method.
     * It is automatically populated with
     * all resources defined in the project.
     * If required, comment out calling this method in getClasses().
     */
    private void addRestResourceClasses(Set<Class<?>> resources) {
        resources.add(bookstore.services.StandardErrorMapper.class);
        resources.add(bookstore.services.ws.services.BookStoreResource.class);
    
    }

}
