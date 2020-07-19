package org.clxmm.bibivueservice.controller;

import org.clxmm.bibivueservice.dao.User;
import org.springframework.web.bind.annotation.*;

/**
 * @author clx
 * @date 2020-07-19 12:53
 */
@RestController
@RequestMapping("hello")
public class HelloController {


    @GetMapping("/hello")
    public String hello() {

        return "hello vue";
    }


    @GetMapping("/hello1")
    public String hello1() {

        return "hello vue1";
    }

    @GetMapping("books")
    public String books(String id) {
        return id;
    }


    @GetMapping("books/{id}")
    public String booksId(@PathVariable("id") String id) {
        return id;
    }

    @DeleteMapping("books1")
    public String booksIdDs(String id) {
        return id;
    }

    @DeleteMapping("books/{id}")
    public String booksIdD(@PathVariable("id") String id) {
        return id;
    }

    @PostMapping("/books")
    public String booksPost(String uanme,String pwd) {

        return "usename:" +uanme +"; pwd:"+pwd;
    }

    @PostMapping("/booksJson")
    public User booksPostJson( @RequestBody User user) {

        return user;
    }


    @PutMapping("/books/{id}")
    public User booksPut(@PathVariable("id") String id, @RequestBody User user) {

        user.setId(id);
        return user;
    }



}
