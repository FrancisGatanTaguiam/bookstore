/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package springboot.book.store.service;

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import springboot.book.store.entity.BookEntity;
import springboot.book.store.repository.BookRepository;

/**
 *
 * @author joel
 */
@Service
public class BookService {
    @Autowired
    private BookRepository bookRepository;
    
    public BookEntity save(BookEntity data){
        BookEntity retval = null;
        if(data!=null){
            retval =bookRepository.save(data);
            return retval;
        }else{
            return retval;
        }
        
    }

    public BookEntity update(BookEntity book) {
        System.out.println("updating book....");
        return bookRepository.save(book);
    }
    
    public List<BookEntity> getAll() {
       List<BookEntity> books = new ArrayList<>();
       bookRepository.findAll().forEach(books::add);
       System.out.println("getall: "+books);
       return books;
    }
}
