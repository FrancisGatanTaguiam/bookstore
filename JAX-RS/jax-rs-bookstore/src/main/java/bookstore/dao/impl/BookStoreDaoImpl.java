/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bookstore.dao.impl;

import bookstore.dao.BookStoreDao;
import bookstore.dao.exception.DaoException;
import bookstore.services.entity.BookStoreEntity;
import bookstore.services.ws.handler.BookStoreHandler;
import java.math.BigInteger;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 *
 * @author Francis G. Taguiam <Francis G. Taguiam at your.org>
 */
public class BookStoreDaoImpl extends CommonDaoImpl<BookStoreEntity, BigInteger> implements BookStoreDao {

    private static final Logger LOG = LoggerFactory.getLogger(BookStoreDaoImpl.class);

    public BookStoreDaoImpl(EntityManager entityManager) {
        super(BookStoreEntity.class, entityManager);
    }

    @Override
    public List<BookStoreEntity> fetchTableBookStore() throws DaoException {

        List<BookStoreEntity> retval = null;

        try {
            Query query = getEntityManager().createNamedQuery("FETCH_ALL_BOOK_ENTITY");

            retval = (List<BookStoreEntity>) query.getResultList();
        } catch (Throwable e) {
            LOG.debug("ERROR IN IMPLEMENTATION:" + e);
        }
        return retval;
    }

}
