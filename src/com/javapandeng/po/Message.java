package com.javapandeng.po;

import java.io.Serializable;
import java.util.Date;

/**
 * @author hangzhi1063
 * @date 2020/11/5 19:22
 */
public class Message implements Serializable {
    private Integer id ;
    private String name;
    private String content;
    private String phone;


    @Override
    public String toString() {
        return "Message{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", content='" + content + '\'' +
                ", phone='" + phone + '\'' +
                '}';
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Message() {
    }

    public Message(Integer id, String name, String content, String phone) {
        this.id = id;
        this.name = name;
        this.content = content;
        this.phone = phone;
    }
}
