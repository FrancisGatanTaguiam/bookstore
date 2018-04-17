/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package springboot.book.store.repository;

import java.math.BigInteger;
import java.util.List;
import org.springframework.data.repository.CrudRepository;
import springboot.book.store.entity.BookEntity;

/**
 *
 * @author francis taguiam
 */
public interface BookRepository extends CrudRepository<BookEntity,BigInteger>{
    List<BookEntity> findAll();
}
