package ro.school.repository;

import org.junit.jupiter.api.Test;
import ro.school.model.Book;

import static org.junit.jupiter.api.Assertions.*;

class BookRepoTest {

    @Test
    public void testInsert(){
        Book book = new Book("test","2021/06/13",2);
        BookRepo bookRepo = new BookRepo();

        bookRepo.insertBook(book);
    }

    @Test
    public void testSelectAll(){
        BookRepo bookRepo = new BookRepo();

//        bookRepo.updateId("Cartea 2","2020-01-01");

        bookRepo.delete("Carte 1");

        System.out.println( bookRepo.allBooks());


    }
}