/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package springboot.book.store.response;

import springboot.book.store.entity.BookEntity;

/**
 *
 * @author Francis G. Taguiam <Francis G. Taguiam at your.org>
 */
public class BookResponse extends BaseServiceResponse {

    private BookEntity payload;

    public BookResponse() {
    }

    public BookResponse(BookEntity payload) {
        this.payload = payload;
    }

    public BookResponse(BookEntity payload, ServiceStatus status, String message) {
        super(status, message);
        this.payload = payload;
    }

    public BookResponse(BookEntity payload, String message) {
        super(message);
        this.payload = payload;
    }

    public BookResponse(ServiceStatus status, String message) {
        super(status, message);
    }

    public BookEntity getPayload() {
        return payload;
    }

    public void setPayload(BookEntity payload) {
        this.payload = payload;
    }

}
