package com.cloud.ribbon.entity;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.annotations.GenericGenerator;
import javax.persistence.*;
import java.io.Serializable;

@ToString
@Setter
@Getter
@Entity
@Table(name = "t_product")
//货物和订单是多对多关系 n:n
public class product implements Serializable {
    @Id
    //这个是hibernate主键生成策略
    @GenericGenerator(name = "generator", strategy = "native")
    @GeneratedValue(generator = "generator")
    @Column(name = "p_id", nullable = false)
    private Long p_id;
    @Column(name = "p_name")
    private String p_name;
    @Column(name = "p_price")
    private Double p_price;
}
