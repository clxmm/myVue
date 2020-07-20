package org.clxmm.bibivueservice.dao;

import lombok.Data;

import java.io.Serializable;

/**
 * @author clx
 * @date 2020-07-20 19:51
 */
@Data
public class Book  implements Serializable {


    private String name;

    private Long date = System.currentTimeMillis();

    private Integer id;

    public Book() {
    }

    public Book(String name, Long data, Integer id) {
        this.name = name;
        this.date = data;
        this.id = id;
    }
}
