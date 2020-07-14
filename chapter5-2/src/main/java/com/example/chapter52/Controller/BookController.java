package com.example.chapter52.Controller;

import com.example.chapter52.Bean.Book;
import com.example.chapter52.Service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class BookController {
    @Autowired
    BookService bookService;
    @GetMapping("/getBooks")
    public String getBooks(){
        Book b1 = new Book();
        b1.setName("西厢记");
        b1.setAuthor("王实甫");
        int i = bookService.addBook(b1);
        System.out.println("addBook>>>"+ i);
        Book b2 = new Book();
        b2.setId(1);
        b2.setName("朝花夕拾");
        b2.setAuthor("鲁迅");
        int updateBook = bookService.updateBook(b2);
        System.out.println("updateBook>>>"+updateBook);
        Book b3 = bookService.getBookById(1);
        System.out.println("getBookById>>>"+b3);
        int delete = bookService.deleteBookById(2);
        System.out.println("deleteBookById>>>"+delete);
        List<Book> allBooks = bookService.getAllBooks();
        System.out.println("getAllBooks>>>"+allBooks);
        return "已修改表";
    }
}