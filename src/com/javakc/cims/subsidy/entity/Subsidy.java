package com.javakc.cims.subsidy.entity;

import com.javakc.cims.person.entity.Person;

import java.math.BigDecimal;
import java.util.Date;

/**
 * @program: cims
 * @description: 补贴管理实体类
 * @author: zhou hong gang
 * @create: 2020-11-10 10:02
 */
public class Subsidy {
    //主键
    private int id;
    //补贴月份
    private Date month;
    //补贴金额
    private BigDecimal money;
    //类型 1：供暖 2：物业
    private int type;
    //补贴的人员
    private Person person;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getMonth() {
        return month;
    }

    public void setMonth(Date month) {
        this.month = month;
    }

    public BigDecimal getMoney() {
        return money;
    }

    public void setMoney(BigDecimal money) {
        this.money = money;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }
}
