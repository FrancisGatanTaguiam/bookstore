/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bookstore.services.ws.services;

import bookstore.data.cons.BookStoreData;
import bookstore.data.resp.BookStoreListResponse;
import bookstore.data.resp.BookStoreResponse;
import bookstore.services.ws.handler.BookStoreHandler;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

/**
 *
 * @author Francis G. Taguiam <Francis G. Taguiam at your.org>
 */
@Path("BookStoreResource")
public class BookStoreResource {

    private final BookStoreHandler handler = new BookStoreHandler();

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    @Path("insertInBookStore")
    public BookStoreResponse insertInBookStore(BookStoreData data) {
        return handler.insertInBookStore(data);
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    @Path("updateInBookStore")
    public BookStoreResponse updateInBookStore(BookStoreData data) {
        return handler.updateInBookStore(data);
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("updateInBookStore")
    public BookStoreListResponse updateInBookStore() {
        return handler.fetchTableBookStore();
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    @Path("deleteInBookStore")
    public BookStoreResponse deleteInBookStore(BookStoreData data) {
        return handler.deleteInBookStore(data);
    }
    
}
