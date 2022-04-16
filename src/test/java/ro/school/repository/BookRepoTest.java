package ro.school.repository;

import org.junit.jupiter.api.Test;
import ro.school.model.Book;

import static org.junit.jupiter.api.Assertions.*;


class BookRepoTest {

    Book book;

    @Test
    public void testInsert(){
        book = new Book("test","2021/06/13",2);
        BookRepo bookRepo = new BookRepo();

        bookRepo.insertBook(book);

        assertEquals("test", book.getBookName());
//        assertEquals("teszx", book.getBookName());
    }

    @Test
    public void testDelete(){

        BookRepo bookRepo = new BookRepo();

        assertEquals(true, bookRepo.delete("Carte 1"));

    }

    @Test
    public void testUpdateDate(){
        BookRepo bookRepo = new BookRepo();
        bookRepo.updateDate("Cartea 2","2020-01-01");

        assertEquals("2020-01-01",bookRepo.updateDate("as","2020-01-01"));

    }

    @Test
    public void testSelectAll(){
        BookRepo bookRepo = new BookRepo();

        System.out.println( bookRepo.allBooks());


    }
}