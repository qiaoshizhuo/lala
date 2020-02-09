package com.cloud.ribbon.entity;




import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

@Setter
@Getter
@Entity
@Table(name = "t_user")
//用户
//用户和货物订单是1：n,一对多关系
    public class user {
        @Id
        //这个是hibernate主键生成策略
        @GenericGenerator(name="generator",strategy="native")
        @GeneratedValue(generator="generator")
        @Column(name = "u_id",nullable=false)
        private Long u_id;
        @Column(name ="u_name")
        private String u_name;
        @Column(name ="u_password")
        private String u_password;
}
