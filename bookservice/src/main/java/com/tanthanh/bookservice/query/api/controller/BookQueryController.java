package com.tanthanh.bookservice.query.api.controller;

import com.tanthanh.bookservice.query.api.model.BookResponseModel;
import com.tanthanh.bookservice.query.api.queries.GetAllBooksQuery;
import com.tanthanh.bookservice.query.api.queries.GetBooksQuery;
import org.axonframework.messaging.responsetypes.ResponseTypes;
import org.axonframework.queryhandling.QueryGateway;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("api/v1/books")
public class BookQueryController {

    @Autowired
    private QueryGateway queryGateway;

    @GetMapping("/{bookId}")
    public BookResponseModel getBookDetail(@PathVariable String bookId) {
        GetBooksQuery getBooksQuery = new GetBooksQuery();
        getBooksQuery.setBookId(bookId);
        BookResponseModel bookResponseModel = queryGateway.query(getBooksQuery, ResponseTypes.instanceOf(BookResponseModel.class)).join();
        return bookResponseModel;
    }

    @GetMapping
    public List<BookResponseModel> getAllBooks() {
        GetAllBooksQuery getAllBooksQuery = new GetAllBooksQuery();
        List<BookResponseModel> list = queryGateway.query(getAllBooksQuery, ResponseTypes.multipleInstancesOf(BookResponseModel.class)).join();
        return list;
    }

}
