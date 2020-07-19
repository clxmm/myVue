package org.clxmm.bibivueservice.dao;

import lombok.ToString;

@ToString
public class User {
    private String ids;
    private String uname;
    private String pwd;


    public String getId() {
        return ids;
    }

    public void setId(String id) {
        this.ids = id;
    }

    public String getUname() {
        return uname;
    }

    public void setUname(String uname) {
        this.uname = uname;
    }

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }
}