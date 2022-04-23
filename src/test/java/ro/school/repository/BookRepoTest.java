package ro.school.repository;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ro.school.model.Book;

import static org.junit.jupiter.api.Assertions.*;


class BookRepoTest {

    Book book;
    BookRepo bookRepo;

    @BeforeEach
    public void initial(){
        bookRepo = new BookRepo();
    }

    @Test
    public void testInsert(){
        book = new Book("test","2021/06/13",2);

        bookRepo.insertBook(book);

        assertEquals("test", book.getBookName());
        assertEquals("2021/06/13", book.getDateCreated());


    }

    @Test
    public void testReturnBook(){
      assertEquals("Carte 4",bookRepo.returnByName2("Carte 4").getBookName());
      assertEquals("2017-05-25",bookRepo.returnByName2("Carte 4").getDateCreated());
      assertEquals(4,bookRepo.returnByName2("Carte 4").getStudentId());
      assertEquals(4,bookRepo.returnByName2("Carte 4").getId());
    }

    @Test
    public void testDelete(){
        System.out.println(bookRepo.allBooks());
    bookRepo.delete("test");
        System.out.println(bookRepo.allBooks());

    }

    @Test
    public void testUpdateDate(){

        bookRepo.updateDate("Cartea 2","2020-01-02");

        assertEquals("2020-01-02",bookRepo.updateDate("Carte 2","2020-01-02"));

        System.out.println(bookRepo.allBooks());

    }

    @Test
    public void testSelectAll(){

        assertEquals(false,bookRepo.allBooks().size()<0);
        assertEquals(true,bookRepo.allBooks().size()>0);

    }
}