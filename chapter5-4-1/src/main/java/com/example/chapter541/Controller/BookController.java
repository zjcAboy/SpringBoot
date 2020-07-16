package com.example.chapter541.Controller;

import com.example.chapter541.Bean.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

@RestController
public class BookController {
    @Resource(name = "jdbcTemplateOne")
    JdbcTemplate jdbcTemplateOne;
    @Autowired
    @Qualifier("jdbcTemplateTwo")
    JdbcTemplate jdbcTemplateTwo;
    @GetMapping("/test1")
    public void test1(){
        List<Book> book1 = jdbcTemplateOne.query("select * from book",new BeanPropertyRowMapper<>(Book.class));
        List<Book> book2 = jdbcTemplateTwo.query("select * from book",new BeanPropertyRowMapper<>(Book.class));
        System.out.println("books1:"+book1);
        System.out.println("books2:"+book2);
    }
}
