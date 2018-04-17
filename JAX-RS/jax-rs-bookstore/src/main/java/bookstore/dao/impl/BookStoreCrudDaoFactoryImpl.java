/*
 * @Copyright DTI 2016
 * All Rights Reserved
 */
package bookstore.dao.impl;

import javax.persistence.EntityManagerFactory;
import bookstore.dao.BookStoreCrudDaoFactory;
import bookstore.dao.BookStoreDao;


/**
 *
 * @since August 4, 2016
 */
public class BookStoreCrudDaoFactoryImpl implements BookStoreCrudDaoFactory {

    private final EntityManagerFactory emf;

    public BookStoreCrudDaoFactoryImpl(EntityManagerFactory emf) {
        this.emf = emf;
    }

    @Override
    public BookStoreDao getBookStoreDao() {
        return new BookStoreDaoImpl(emf.createEntityManager());
    }
    

}
