package com.javapandeng.po;

import java.io.Serializable;

/**
 * @author hangzhi1063
 * @date 2020/11/5 14:58
 */
public class OrderDetail  implements Serializable {
    //id 主键
    private Integer id;
    //商品编号
    private Integer itemId;
    //订单编号
    private Integer orderId;
    //状态0未退货 1已退货
    private Integer status;
    //总数
    private Integer num;
    //小计
    private String total;

    private Item item;

    @Override
    public String toString() {
        return "OrderDetail{" +
                "id=" + id +
                ", itemId=" + itemId +
                ", orderId=" + orderId +
                ", status=" + status +
                ", num=" + num +
                ", total='" + total + '\'' +
                ", item=" + item +
                '}';
    }

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

    public Integer getOrderId() {
        return orderId;
    }

    public void setOrderId(Integer orderId) {
        this.orderId = orderId;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Integer getNum() {
        return num;
    }

    public void setNum(Integer num) {
        this.num = num;
    }

    public String getTotal() {
        return total;
    }

    public void setTotal(String total) {
        this.total = total;
    }

    public Item getItem() {
        return item;
    }

    public void setItem(Item item) {
        this.item = item;
    }

    public OrderDetail() {
    }

    public OrderDetail(Integer id, Integer itemId, Integer orderId, Integer status, Integer num, String total, Item item) {
        this.id = id;
        this.itemId = itemId;
        this.orderId = orderId;
        this.status = status;
        this.num = num;
        this.total = total;
        this.item = item;
    }
}
