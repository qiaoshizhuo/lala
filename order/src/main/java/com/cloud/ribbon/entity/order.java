package com.cloud.ribbon.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;



@Setter
@Getter
@Entity
@Table(name = "t_order")
public class order{
    //订单号
    @Id
    //这个是hibernate主键生成策略
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "o_id",nullable=false)
    private Long o_id;
    @Column(name = "o_price")
    private Double o_price;
    @Column(name = "u_id")
    private Long u_id;
    @JsonIgnore
    @OneToMany(mappedBy = "order")
    @Cascade(org.hibernate.annotations.CascadeType.ALL)
    private Set<orderItem> orderItems=new HashSet<orderItem>();
}
