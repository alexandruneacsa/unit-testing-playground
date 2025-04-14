package com.testing.mockito.book;

import com.testing.mockito.mocks.book.Book;
import com.testing.mockito.mocks.book.BookRepository;
import com.testing.mockito.mocks.book.BookService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Captor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class BookServiceTest {

    @Mock
    private BookRepository bookRepository;

    @InjectMocks
    private BookService bookService;

    @Captor
    ArgumentCaptor<Book> inputCaptorBook;

    @Captor
    ArgumentCaptor<String> inputStringCaptor;

    @Test
    public void testGetBooks() {

        when(bookRepository.getBook(anyString())).thenThrow(new IllegalArgumentException("Wrong id"));

        try {

            bookService.getBook("id1");

            fail();
        } catch (Exception ex) {

            assertInstanceOf(IllegalArgumentException.class, ex);
            assertEquals("Wrong id", ex.getMessage());
        }
    }

    @Test
    public void testAddBook() {

        bookService.addBook(new Book("1", "Poezii", "Mihai Eminescu"));

        verify(bookRepository, times(1)).addBook(isA(Book.class));
    }

    @Test
    public void testUpdateBook() {

        bookService.updateBook(new Book("2", "Povestiri", "Ion Creanga"));

        verify(bookRepository, atLeastOnce()).updateBook(isA(Book.class));
    }

    @Test
    public void testDeleteBook() {

        bookService.deleteBook("1");

        verify(bookRepository, atLeastOnce()).deleteBook(anyString());
    }

    @Test
    public void addOneMoreBookTest() {

        ArgumentCaptor<Book> inputBookCaptor = ArgumentCaptor.forClass(Book.class);

        doNothing().when(bookRepository).addBook(inputBookCaptor.capture());

        var book = new Book("5", "Nuvele", "Ion Luca Caragiale");
        bookService.addBook(book);

        assertEquals(book, inputBookCaptor.getValue());

        verify(bookRepository, times(1)).addBook(isA(Book.class));
    }

    @Test
    public void deleteOneMoreBook() {

        ArgumentCaptor<String> inputStringCaptor = ArgumentCaptor.forClass(String.class);

        doNothing().when(bookRepository).deleteBook(inputStringCaptor.capture());

        bookService.deleteBook("1");

        assertEquals("1", inputStringCaptor.getValue());

        verify(bookRepository, atLeastOnce()).deleteBook(anyString());
    }
}
