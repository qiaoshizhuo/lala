package com.cloud.ribbon.entity;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

//支付系统
//支付和订单是一对一关系  1:1
@ToString

@Entity
@Table(name = "t_billing")
public class billing {

    private Long b_id;
    //订单
    //cascade = CascadeType.ALL表示的是级联操作中的all。
//    @OneToOne
//    @JoinColumn(name = "o_id",referencedColumnName="o_id",nullable=false)
    @Column(name = "o_id")
    private Long o_id;
    //是否支付，1表示支付，0表示没有支付
    @Column(name = "isBilling")
    private Integer isBilling;
    //支付号
    @Id
    //这个是hibernate主键生成策略
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "b_id",nullable=false)
    public Long getB_id() {
        return b_id;
    }

    public void setB_id(Long b_id) {
        this.b_id = b_id;
    }

    public Long getO_id() {
        return o_id;
    }

    public void setO_id(Long o_id) {
        this.o_id = o_id;
    }

    public Integer getIsBilling() {
        return isBilling;
    }

    public void setIsBilling(Integer isBilling) {
        this.isBilling = isBilling;
    }
}
