/*
 * @Copyright DTI 2016
 * All Rights Reserved
 */
package bookstore.dao.util;

import bookstore.dao.impl.BookStoreCrudDaoFactoryImpl;
import javax.persistence.Persistence;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import bookstore.dao.BookStoreCrudDaoFactory;

/**
 * <p>
 * Responsible for creating and providing the instance of the Entity Manager
 * Factory.
 * </p>
 *
 * @since June 21, 2016
 */
public abstract class DAOUtils {
    private static final BookStoreCrudDaoFactory DAOFACTORY;
    private static Logger LOG = LoggerFactory.getLogger(DAOUtils.class);
    static {
        try {
            DAOFACTORY = new BookStoreCrudDaoFactoryImpl(Persistence.createEntityManagerFactory("francis-project"));
        } catch (Throwable t) {
            LOG.debug("dao utils error: "+t.getLocalizedMessage() + t);
            throw new ExceptionInInitializerError(t);
        }
    }
    
    public static BookStoreCrudDaoFactory getDaoFactory() {
        return DAOFACTORY;
    }
    
}
