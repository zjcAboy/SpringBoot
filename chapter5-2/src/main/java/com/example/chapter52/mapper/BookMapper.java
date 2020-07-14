package com.example.chapter52.mapper;
import com.example.chapter52.Bean.Book;

import java.util.List;


public interface BookMapper {
    int addBook(Book book);
    int deleteBookById(Integer id);
    int updateBookById(Book book);
    Book getBookById(Integer id);
    List<Book> getAllBooks();
}
