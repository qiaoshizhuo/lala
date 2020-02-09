package com.cloud.ribbon.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Setter
@Getter
@Entity
@Table(name = "t_cart_item")
//货物和订单是多对多关系 n:n
public class cartItem {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "с_id",nullable=false)
    private Long с_id;
    @Column(name = "u_id")
    private Long u_id;
    @Column(name = "p_id")
    private Long p_id;
    @Column(name = "p_name")
    private String p_name;
    @Column(name = "oi_num")
    private Integer oi_num;
    @Column(name = "p_price")
    private Double p_price;
    @Column(name = "oi_price")
    private Double oi_price;

}
