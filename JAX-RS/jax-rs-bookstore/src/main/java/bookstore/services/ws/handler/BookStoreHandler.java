/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bookstore.services.ws.handler;

import bookstore.dao.BookStoreCrudDaoFactory;
import bookstore.dao.BookStoreDao;
import bookstore.dao.exception.DaoException;
import bookstore.dao.util.DAOUtils;
import bookstore.data.cons.BookStoreData;
import bookstore.data.enums.ServiceStatus;
import bookstore.data.resp.BookStoreListResponse;
import bookstore.data.resp.BookStoreResponse;
import bookstore.services.entity.BookStoreEntity;
import com.google.gson.Gson;
import java.util.ArrayList;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 *
 * @author Francis G. Taguiam <Francis G. Taguiam at your.org>
 */
public class BookStoreHandler {

    private static final Logger LOG = LoggerFactory.getLogger(BookStoreHandler.class);
    private final Gson gson = new Gson();
    private static final BookStoreCrudDaoFactory daoFactory = DAOUtils.getDaoFactory();
    
    //insert in bookstore
    public BookStoreResponse insertInBookStore(BookStoreData data) {

        BookStoreResponse retval = null;
        BookStoreDao dao = daoFactory.getBookStoreDao();
        BookStoreEntity entity = new BookStoreEntity();
        if (data.getBookName() != null) {

            entity.setBookId(null);
            entity.setBookAuthor(data.getBookAuthor());
            entity.setBookDescription(data.getBookDescription());
            entity.setBookName(data.getBookName());

            try {
                dao.save(entity);
                retval = new BookStoreResponse(ServiceStatus.SUCCESS, "SUCCESSFULLY SAVE");
                LOG.debug("SUCCESSFULLY SAVE");
            } catch (DaoException e) {
                LOG.debug("ERROR IN SAVING" + e);
            } finally {
                dao.close();
            }

        } else {
            retval = new BookStoreResponse(ServiceStatus.FAILED, "THE DATA YOU THROW IS INCOMPLETE:");
            LOG.debug("THE DATA YOU THROW IS INCOMPLETE:");
        }
        return retval;
    }
    
    //update in bookstore
    public BookStoreResponse updateInBookStore(BookStoreData data) {

        BookStoreResponse retval = null;
        BookStoreDao dao = daoFactory.getBookStoreDao();
        if (data.getBookId() != null) {
            try {
                BookStoreEntity findById = dao.findById(data.getBookId());

                if (findById != null) {

                    findById.setBookId(findById.getBookId());
                    findById.setBookAuthor(data.getBookAuthor() != null ? data.getBookAuthor() : findById.getBookAuthor());
                    findById.setBookDescription(data.getBookDescription() != null ? data.getBookDescription() : findById.getBookDescription());
                    findById.setBookName(data.getBookName() != null ? data.getBookName() : findById.getBookName());

                    dao.update(findById);
                    retval = new BookStoreResponse(ServiceStatus.SUCCESS, "SUCCESSFULLY UPDATE");
                    LOG.debug("SUCCESSFULLY UPDATE");
                } else {
                    retval = new BookStoreResponse(ServiceStatus.FAILED, "NO ID FOUND!");
                    LOG.debug("NO ID FOUND!");
                }
            } catch (DaoException e) {
                LOG.debug("FAILED TO UPDATE!" + e);
            } finally {
                dao.close();
            }
        } else {
            retval = new BookStoreResponse(ServiceStatus.FAILED, "THE DATA YOU THROW IS INCOMPLETE:");
            LOG.debug("THE DATA YOU THROW IS INCOMPLETE:");
        }
        return retval;
    }
    
    //fetch table book store
    public BookStoreListResponse fetchTableBookStore() {

        BookStoreListResponse retval = null;
        BookStoreDao dao = daoFactory.getBookStoreDao();
        List<BookStoreData> dataList = new ArrayList<>();

        try {
            List<BookStoreEntity> entityList = dao.fetchTableBookStore();

            for (BookStoreEntity passEnt : entityList) {
                String payload = gson.toJson(passEnt);
                BookStoreData data = gson.fromJson(payload, BookStoreData.class);

                dataList.add(data);

                retval = new BookStoreListResponse(ServiceStatus.SUCCESS, "SUCCESSFULLY FETCH");
                LOG.debug("SUCCESSFULLY FETCH");
            }
        } catch (DaoException e) {
            LOG.debug("ERROR IN FETCHING" + e);
        } finally {
            dao.close();
        }
        return retval;
    }
    
    //delete
    public BookStoreResponse deleteInBookStore(BookStoreData data) {

        BookStoreResponse retval = null;
        BookStoreDao dao = daoFactory.getBookStoreDao();
        if (data.getBookId() != null) {
            try {
                BookStoreEntity findById = dao.findById(data.getBookId());

                if (findById != null) {

                    findById.setBookId(findById.getBookId());

                    dao.hardDelete(findById);
                    retval = new BookStoreResponse(ServiceStatus.SUCCESS, "SUCCESSFULLY UPDATE");
                    LOG.debug("SUCCESSFULLY UPDATE");
                } else {
                    retval = new BookStoreResponse(ServiceStatus.FAILED, "NO ID FOUND!");
                    LOG.debug("NO ID FOUND!");
                }
            } catch (DaoException e) {
                LOG.debug("FAILED TO UPDATE!" + e);
            } finally {
                dao.close();
            }
        } else {
            retval = new BookStoreResponse(ServiceStatus.FAILED, "THE DATA YOU THROW IS INCOMPLETE:");
            LOG.debug("THE DATA YOU THROW IS INCOMPLETE:");
        }
        return retval;
    }
}
