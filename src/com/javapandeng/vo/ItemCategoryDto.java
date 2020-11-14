package com.javapandeng.vo;

import com.javapandeng.po.ItemCategory;

import java.util.List;

/**
 * @author hangzhi1063
 * @date 2020/11/7 9:36
 */
public class ItemCategoryDto {

    private ItemCategory father;
    private List<ItemCategory> children;

    public ItemCategory getFather() {
        return father;
    }

    public void setFather(ItemCategory father) {
        this.father = father;
    }

    public List<ItemCategory> getChildren() {
        return children;
    }

    public void setChildren(List<ItemCategory> children) {
        this.children = children;
    }

    public ItemCategoryDto() {
    }

    public ItemCategoryDto(ItemCategory father, List<ItemCategory> children) {
        this.father = father;
        this.children = children;
    }
}
