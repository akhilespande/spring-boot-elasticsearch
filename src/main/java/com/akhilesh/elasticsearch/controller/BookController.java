package com.akhilesh.elasticsearch.controller;

import com.akhilesh.elasticsearch.bean.Book;
import com.akhilesh.elasticsearch.dao.BookDao;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/books")
public class BookController {

    private BookDao bookDao;

    public BookController(BookDao bookDao) {
        this.bookDao = bookDao;
    }

    @PostMapping
    public Book insertBook(@RequestBody Book book) throws Exception{
        return bookDao.insertBook(book);
    }

    @GetMapping("/{id}")
    public Map<String, Object> getBookById(@PathVariable String id){
        return bookDao.getBookById(id);
    }

    @PutMapping("/{id}")
    public Map<String, Object> updateBookById(@RequestBody Book book, @PathVariable String id){
        return bookDao.updateBookById(id, book);
    }

    @DeleteMapping("/{id}")
    public void deleteBookById(@PathVariable String id){
         bookDao.deleteBookById(id);
    }
}
