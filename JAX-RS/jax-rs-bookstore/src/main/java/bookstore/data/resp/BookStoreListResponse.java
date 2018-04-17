/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bookstore.data.resp;

import bookstore.data.cons.BookStoreData;
import bookstore.data.enums.ServiceStatus;
import java.util.List;

/**
 *
 * @author Francis G. Taguiam <Francis G. Taguiam at your.org>
 */
public class BookStoreListResponse extends BaseServiceResponse {

    private List<BookStoreData> payload;

    public BookStoreListResponse() {
    }

    public BookStoreListResponse(List<BookStoreData> payload) {
        this.payload = payload;
    }

    public BookStoreListResponse(List<BookStoreData> payload, ServiceStatus status, String message) {
        super(status, message);
        this.payload = payload;
    }

    public BookStoreListResponse(List<BookStoreData> payload, String message) {
        super(message);
        this.payload = payload;
    }

    public BookStoreListResponse(ServiceStatus status, String message) {
        super(status, message);
    }

    public List<BookStoreData> getPayload() {
        return payload;
    }

    public void setPayload(List<BookStoreData> payload) {
        this.payload = payload;
    }

}
