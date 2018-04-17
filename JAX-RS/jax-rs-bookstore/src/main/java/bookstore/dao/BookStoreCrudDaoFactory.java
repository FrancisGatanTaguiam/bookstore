/*
 * @Copyright DTI 2016
 * All Rights Reserved
 */
package bookstore.dao;


/**
 * <p>
 * Data access object factory for creating DAOs that connects to 
 * Business Name Registration System (BNRS) Schema.
 * </p>
 * 
 * @since August 4, 2016
 */
public interface BookStoreCrudDaoFactory {
    BookStoreDao getBookStoreDao();
}
