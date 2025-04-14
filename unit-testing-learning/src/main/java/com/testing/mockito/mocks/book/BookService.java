package com.testing.mockito.mocks.book;

import lombok.RequiredArgsConstructor;

import java.util.List;

@RequiredArgsConstructor
public class BookService {

    private BookRepository bookRepository;

    public Book getBook(String id) {

        return bookRepository.getBook(id);
    }

    public List<Book> getBooks(String query) {

        return bookRepository.getBooks(query);
    }

    public void addBook(Book book) {

        bookRepository.addBook(book);
    }

    public void updateBook(Book book){

        bookRepository.updateBook(book);
    }

    public void deleteBook(String id) {

        bookRepository.deleteBook(id);
    }
}
