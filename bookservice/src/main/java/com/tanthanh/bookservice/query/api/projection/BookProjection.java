package com.tanthanh.bookservice.query.api.projection;

import com.tanthanh.bookservice.command.api.data.Book;
import com.tanthanh.bookservice.command.api.data.BookRepository;
import com.tanthanh.bookservice.query.api.model.BookResponseModel;
import com.tanthanh.bookservice.query.api.queries.GetAllBooksQuery;
import com.tanthanh.bookservice.query.api.queries.GetBooksQuery;
import org.axonframework.queryhandling.QueryHandler;
import org.checkerframework.checker.units.qual.A;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class BookProjection {

    @Autowired
    private BookRepository bookRepository;

    @QueryHandler
    public BookResponseModel handle(GetBooksQuery query) {
        BookResponseModel model = new BookResponseModel();
        Book book = bookRepository.getByBookId(query.getBookId());
        BeanUtils.copyProperties(book, model);
        return model;
    }

    @QueryHandler
    public List<BookResponseModel> handle(GetAllBooksQuery query) {
        List<Book> listEntity = bookRepository.findAll();
        List<BookResponseModel> listBook = new ArrayList<>();
        listEntity.forEach(s -> {
            BookResponseModel model = new BookResponseModel();
            BeanUtils.copyProperties(s, model);
            listBook.add(model);
        });
        return listBook;
    }
}
