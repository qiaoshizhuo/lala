package com.cloud.ribbon.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Setter
@Getter
@Entity
@Table(name = "t_orderItem")
//货物和订单是多对多关系 n:n
public class orderItem {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "oi_id",nullable=false)
    private Long oi_id;
    @Column(name = "p_id")
    private Long p_id;
    @Column(name = "oi_num")
    private Integer oi_num;
    @Column(name = "oi_price")
    private Double oi_price;
    @ManyToOne
    @JoinColumn(name="o_id")
    private order order;
}
