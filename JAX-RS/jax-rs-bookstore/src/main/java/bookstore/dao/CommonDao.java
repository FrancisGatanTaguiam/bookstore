/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bookstore.dao;

import bookstore.dao.exception.DaoException;

/**
 * <p>
 * Provides all the basic functionality that should be offered
 * by a Data Access Object (DAO).
 * </p>
 * 
 * @since December 10, 2016
 *
 * @param <ENTITYTYPE> The type of entity being handled by this DAO.
 * @param <IDTYPE> The type of ID used by the entity.
 */
public interface CommonDao<ENTITYTYPE, IDTYPE> {
    ENTITYTYPE findById(final IDTYPE id) throws DaoException;
    void save(final ENTITYTYPE entity) throws DaoException;
    void update(final ENTITYTYPE entity) throws DaoException;
    void softDelete(final ENTITYTYPE entity) throws DaoException;
    void hardDelete(final ENTITYTYPE entity) throws DaoException;
    void close();
}
