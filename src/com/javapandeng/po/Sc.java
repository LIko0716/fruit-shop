package com.javapandeng.po;

import java.io.Serializable;

/**
 * @author hangzhi1063
 * @date 2020/11/8 10:14
 */
public class Sc  implements Serializable {
   private Integer id;
    private Integer itemId;
    private Item item;
    private Integer userId;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getItemId() {
        return itemId;
    }

    public void setItemId(Integer itemId) {
        this.itemId = itemId;
    }

    public Item getItem() {
        return item;
    }

    public void setItem(Item item) {
        this.item = item;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Sc(Integer id, Integer itemId, Item item, Integer userId) {
        this.id = id;
        this.itemId = itemId;
        this.item = item;
        this.userId = userId;
    }

    public Sc() {
    }
}
