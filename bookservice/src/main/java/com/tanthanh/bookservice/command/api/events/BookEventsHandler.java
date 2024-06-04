package com.tanthanh.bookservice.command.api.events;

import com.tanthanh.bookservice.command.api.data.Book;
import com.tanthanh.bookservice.command.api.data.BookRepository;
import org.axonframework.eventhandling.EventHandler;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class BookEventsHandler {

    @Autowired
    private BookRepository bookRepository;

    @EventHandler
    private void on(BookCreatedEvent event) {
        Book book = new Book();
        BeanUtils.copyProperties(event, book);
        bookRepository.save(book);
    }

    @EventHandler
    private void on(BookUpdatedEvent event) {
        Book book = bookRepository.getByBookId(event.getBookId());
        book.setAuthor(event.getAuthor());
        book.setName(event.getName());
        book.setIsReady(event.getIsReady());
        bookRepository.save(book);

    }

    @EventHandler
    private void on(BookDeletedEvent event) {
        bookRepository.deleteById(event.getBookId());
    }

}
