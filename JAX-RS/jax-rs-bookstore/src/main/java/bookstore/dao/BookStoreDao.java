/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bookstore.dao;

import bookstore.dao.exception.DaoException;
import bookstore.services.entity.BookStoreEntity;
import java.math.BigInteger;
import java.util.List;

/**
 *
 * @author Francis G. Taguiam <Francis G. Taguiam at your.org>
 */
public interface BookStoreDao extends CommonDao<BookStoreEntity, BigInteger>{
    
    List<BookStoreEntity> fetchTableBookStore()throws DaoException;
}
