package com.javapandeng.po;

import java.io.Serializable;
import java.util.List;

/**
 * @author hangzhi1063
 * @date 2020/11/4 10:37
 */
public class Item implements Serializable {
    //主键
    private Integer id;
    //商品名称
    private String name;
    //商品价格
    private String price;
    //收藏数
    private Integer scNum;
    //购买数
    private Integer gmNum;
    //主图
    private String url1;
    //附图1
    private String url2;
    //附图2
    private String url3;
    //附图3
    private String url4;
    //附图4
    private String url5;
    //描述
    private String ms;
    //
    private String pam1;
    private String pam2;
    private String pam3;

    public List<Comment> getPls() {
        return pls;
    }

    public void setPls(List<Comment> pls) {
        this.pls = pls;
    }


    private String val3;
    private String val2;
    private String val1;


    private Integer type;
    //折扣
    private Integer zk;
    //类别id一级
    private Integer category_id_one;
    //类别id二级
    private Integer category_id_two;
    //是否删除
    private Integer isDelete;
    private ItemCategory erji;
    private ItemCategory yiji;

    private List<Comment> pls;

    @Override
    public String toString() {
        return "Item{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", price='" + price + '\'' +
                ", scNum=" + scNum +
                ", gmNum=" + gmNum +
                ", url1='" + url1 + '\'' +
                ", url2='" + url2 + '\'' +
                ", url3='" + url3 + '\'' +
                ", url4='" + url4 + '\'' +
                ", url5='" + url5 + '\'' +
                ", ms='" + ms + '\'' +
                ", pam1='" + pam1 + '\'' +
                ", pam2='" + pam2 + '\'' +
                ", pam3='" + pam3 + '\'' +
                ", val3='" + val3 + '\'' +
                ", val2='" + val2 + '\'' +
                ", val1='" + val1 + '\'' +
                ", type=" + type +
                ", zk=" + zk +
                ", category_id_one=" + category_id_one +
                ", category_id_two=" + category_id_two +
                ", isDelete=" + isDelete +
                ", erji=" + erji +
                '}';
    }

    public Integer getId() {
        return id;
    }

    public ItemCategory getYiji() {
        return yiji;
    }

    public void setYiji(ItemCategory yiji) {
        this.yiji = yiji;
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

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public Integer getScNum() {
        return scNum;
    }

    public void setScNum(Integer scNum) {
        this.scNum = scNum;
    }

    public Integer getGmNum() {
        return gmNum;
    }

    public void setGmNum(Integer gmNum) {
        this.gmNum = gmNum;
    }

    public String getUrl1() {
        return url1;
    }

    public void setUrl1(String url1) {
        this.url1 = url1;
    }

    public String getUrl2() {
        return url2;
    }

    public void setUrl2(String url2) {
        this.url2 = url2;
    }

    public String getUrl3() {
        return url3;
    }

    public void setUrl3(String url3) {
        this.url3 = url3;
    }

    public String getUrl4() {
        return url4;
    }

    public void setUrl4(String url4) {
        this.url4 = url4;
    }

    public String getUrl5() {
        return url5;
    }

    public void setUrl5(String url5) {
        this.url5 = url5;
    }

    public String getMs() {
        return ms;
    }

    public void setMs(String ms) {
        this.ms = ms;
    }

    public String getPam1() {
        return pam1;
    }

    public void setPam1(String pam1) {
        this.pam1 = pam1;
    }

    public String getPam2() {
        return pam2;
    }

    public void setPam2(String pam2) {
        this.pam2 = pam2;
    }

    public String getPam3() {
        return pam3;
    }

    public void setPam3(String pam3) {
        this.pam3 = pam3;
    }

    public String getVal3() {
        return val3;
    }

    public void setVal3(String val3) {
        this.val3 = val3;
    }

    public String getVal2() {
        return val2;
    }

    public void setVal2(String val2) {
        this.val2 = val2;
    }

    public String getVal1() {
        return val1;
    }

    public void setVal1(String val1) {
        this.val1 = val1;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public Integer getZk() {
        return zk;
    }

    public void setZk(Integer zk) {
        this.zk = zk;
    }

    public Integer getCategory_id_one() {
        return category_id_one;
    }

    public void setCategory_id_one(Integer category_id_one) {
        this.category_id_one = category_id_one;
    }

    public Integer getCategory_id_two() {
        return category_id_two;
    }

    public void setCategory_id_two(Integer category_id_two) {
        this.category_id_two = category_id_two;
    }

    public Integer getIsDelete() {
        return isDelete;
    }

    public void setIsDelete(Integer isDelete) {
        this.isDelete = isDelete;
    }

    public ItemCategory getErji() {
        return erji;
    }

    public void setErji(ItemCategory erji) {
        this.erji = erji;
    }
}

