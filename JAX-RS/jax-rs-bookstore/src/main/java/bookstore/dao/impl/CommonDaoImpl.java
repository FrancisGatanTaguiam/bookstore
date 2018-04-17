/*
 * @Copyright DTI 2016
 * All Rights Reserved
 */
package bookstore.dao.impl;

import bookstore.dao.CommonDao;
import bookstore.dao.exception.DaoException;
import bookstore.services.entity.AuditedEntity;
import java.util.Calendar;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.LockModeType;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * <p>
 * Provides the basic implementation for common functions provided by the
 * interface <code>{@link CommonDao}</code>.
 * </p>
 *
 * @since June 22, 2016
 *
 * @param <ENTITYTYPE> The type of entity being handled by this DAO.
 * @param <IDTYPE> The type of ID used by the entity.
 */
public abstract class CommonDaoImpl<ENTITYTYPE, IDTYPE> implements CommonDao<ENTITYTYPE, IDTYPE> {

    private static final Logger LOG = LoggerFactory.getLogger(CommonDaoImpl.class);

    private final Class<ENTITYTYPE> entityType;
    private final EntityManager entityManager;

    public CommonDaoImpl(Class<ENTITYTYPE> entityType, EntityManager entityManager) {
        this.entityType = entityType;
        this.entityManager = entityManager;
    }

    public Class<ENTITYTYPE> getEntityType() {
        return entityType;
    }

    public EntityManager getEntityManager() {
        return entityManager;
    }

    @Override
    public ENTITYTYPE findById(IDTYPE id) throws DaoException {
        LOG.debug("(DAO) Looking for object with id '{}'.", id);

        if (getEntityManager() == null) {
            throw new DaoException("DAO-0000", "missing.entity.manager",
                    "No Entity Manager Found");
        }

        try {
            ENTITYTYPE retval = getEntityManager().find(getEntityType(), id, LockModeType.NONE);

            return retval;
        } catch (Throwable t) {
            LOG.error("ERROR! Failed to Find By ID using value '{}'. {}", id, t.getMessage(), t);
            throw new DaoException("DAO-0001", "error.find.by.id", "Failed to Find Record By ID. " + t.getMessage());
        }
    }

    @Override
    public void save(ENTITYTYPE entity) throws DaoException {
        LOG.debug("(DAO) Saving entity (Is Not Null = '{}').", (entity != null));

        if (getEntityManager() == null) {
            throw new DaoException("DAO-0000", "missing.entity.manager",
                    "No Entity Manager Found");
        }

        EntityTransaction tx = getEntityManager().getTransaction();

        try {
            tx.begin();

            if (entity instanceof AuditedEntity) {
                ((AuditedEntity) entity).setCreatedDate(Calendar.getInstance().getTime());

//                if(((AuditedEntity) entity).getStatusFlag() == null) {
//                    ((AuditedEntity) entity).setStatusFlag('A');
//                }
            }

            getEntityManager().persist(entity);

            tx.commit();
        } catch (Throwable t) {
            if (tx != null) {
                tx.rollback();
            }
            LOG.error("ERROR! Failed to execute save. {}", t.getMessage(), t);
            throw new DaoException("DAO-0002", "error.persist.entity", "Failed to Save Entity Information");
        }
    }

    @Override
    public void update(ENTITYTYPE entity) throws DaoException {
        LOG.debug("(DAO) Updating entity (Is Not Null = '{}').", (entity != null));

        if (getEntityManager() == null) {
            throw new DaoException("DAO-0000", "missing.entity.manager", "No Entity Manager Found");
        }

        EntityTransaction tx = getEntityManager().getTransaction();

        try {
            tx.begin();

            if (entity instanceof AuditedEntity) {
                ((AuditedEntity) entity).setLastModifiedDate(Calendar.getInstance().getTime());
            }

            getEntityManager().merge(entity);

            tx.commit();
        } catch (Throwable t) {
            if (tx != null) {
                tx.rollback();
            }

            LOG.error("ERROR! Failed to execute update. {}", t.getMessage(), t);
            throw new DaoException("DAO-0003", "error.merge.entity", "Failed to Update Entity Information");
        }
    }

    @Override
    public void hardDelete(ENTITYTYPE entity) throws DaoException {
        LOG.debug("(DAO) Hard Delete entity (Is Not Null = '{}').", (entity != null));

        if (getEntityManager() == null) {
            throw new DaoException("DAO-0000", "missing.entity.manager", "No Entity Manager Found");
        }

        EntityTransaction tx = getEntityManager().getTransaction();

        try {
            tx.begin();

            getEntityManager().remove(entity);

            tx.commit();
        } catch (Throwable t) {
            if (tx != null) {
                tx.rollback();
            }

            LOG.error("ERROR! Failed to execute hard delete. {}", t.getMessage(), t);
            throw new DaoException("DAO-0004", "error.hard.delete.entity", "Failed to execute a hard delete on record.");
        }
    }

    @Override
    public void softDelete(ENTITYTYPE entity) throws DaoException {
        LOG.debug("(DAO) Soft Delete entity (Is Not Null = '{}').", (entity != null));

        if (getEntityManager() == null) {
            throw new DaoException("DAO-0000", "missing.entity.manager", "No Entity Manager Found");
        }

        EntityTransaction tx = getEntityManager().getTransaction();

        try {
            tx.begin();

//            if(entity instanceof AuditedEntity) {
//                ((AuditedEntity) entity).setLastModifiedDate(Calendar.getInstance().getTime());
//                ((AuditedEntity) entity).setStatusFlag('D');
//            }
            getEntityManager().merge(entity);

            tx.commit();
        } catch (Throwable t) {
            if (tx != null) {
                tx.rollback();
            }

            LOG.error("ERROR! Failed to execute soft delete. {}", t.getMessage(), t);
            throw new DaoException("DAO-0005", "error.soft.delete.entity", "Failed to execute a soft delete on record.");
        }
    }

    @Override
    public void close() {
        if (getEntityManager() != null && getEntityManager().isOpen()) {
            LOG.debug("(DAO) Closing Entity Manager.");

            getEntityManager().close();
        }
    }
}
