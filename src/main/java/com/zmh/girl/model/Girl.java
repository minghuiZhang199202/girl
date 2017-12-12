package com.zmh.girl.model;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 * <p>@author minghui_zhang </p>
 * <p>description   </p>
 * <p>date  created in  22:24 / 2017/12/12</p>
 * <p>modified by   </p>
 */
@Data
@Entity
public class Girl {
    @Id
    @GeneratedValue
    private Integer id;
    private String name;
    private String cupSize;
    private Integer age;
}
