/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bookstore.data.resp;

import bookstore.data.cons.BookStoreData;
import bookstore.data.enums.ServiceStatus;

/**
 *
 * @author Francis G. Taguiam <Francis G. Taguiam at your.org>
 */
public class BookStoreResponse extends BaseServiceResponse {

    private BookStoreData payload;

    public BookStoreResponse() {
    }

    public BookStoreResponse(BookStoreData payload) {
        this.payload = payload;
    }

    public BookStoreResponse(BookStoreData payload, ServiceStatus status, String message) {
        super(status, message);
        this.payload = payload;
    }

    public BookStoreResponse(BookStoreData payload, String message) {
        super(message);
        this.payload = payload;
    }

    public BookStoreResponse(ServiceStatus status, String message) {
        super(status, message);
    }

    public BookStoreData getPayload() {
        return payload;
    }

    public void setPayload(BookStoreData payload) {
        this.payload = payload;
    }

}
