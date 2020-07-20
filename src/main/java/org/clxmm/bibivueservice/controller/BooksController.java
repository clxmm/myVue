package org.clxmm.bibivueservice.controller;

import com.alibaba.fastjson.JSONObject;
import org.apache.commons.collections.CollectionUtils;
import org.clxmm.bibivueservice.dao.Book;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author clx
 * @date 2020-07-20 19:50
 */
@RestController
@RequestMapping("books")
@CrossOrigin
public class BooksController {


    private static List<Book> bookList = new ArrayList<>();


    static {
        for (int i = 0; i < 4; i++) {
            bookList.add(new Book("book" + i, System.currentTimeMillis(), i));
        }
    }


    @GetMapping("/")
    public List<Book> get() {
        return bookList;
    }


    @PostMapping("/")
    public JSONObject post(@RequestBody Book book) {
        Integer integer = bookList.stream().map(Book::getId).max(Integer::compareTo).get();
        book.setDate(System.currentTimeMillis());
        book.setId(integer + 1);

        boolean b = bookList.stream().anyMatch(book1 -> book1.getName().equals(book.getName()));
        JSONObject object = new JSONObject();
        if (b) {
            object.put("code", 500);
            object.put("msg", "书名重复");
            return object;
        }

        bookList.add(book);
        object.put("code", "200");
        object.put("msg", "成功");
        return object;
    }


    @GetMapping("/{name}")
    public Integer checkBook(@PathVariable("name") String name) {
        boolean b = bookList.stream().anyMatch(book1 -> book1.getName().equals(name));

        if (b) {
            return 2;
        }

        return 1;
    }


    @GetMapping("/getNameById")
    public Book getNameById(Integer id) {
        List<Book> collect = bookList.stream().filter(book -> book.getId().intValue() == id).collect(Collectors.toList());

        if (CollectionUtils.isEmpty(collect)) {
            return new Book();
        }
        return collect.get(0);
    }


    @PutMapping("/")
    public Integer put(@RequestBody Book book) {
        book.setDate(System.currentTimeMillis());


        for (Book book1 : bookList) {
            if (book1.getId().intValue()== book.getId()) {
                book1.setName(book.getName());
                book1.setDate(System.currentTimeMillis());
            }

        }


        return 1;
    }



    @DeleteMapping("/{id}")
    public Integer delete(@PathVariable("id") Integer id) {


        Iterator<Book> it = bookList.iterator();

        while (it.hasNext()) {

            Book next = it.next();
            if (next.getId().intValue() == id) {
                it.remove();
            }
        }


        return 1;

    }

}
