package com.girl.model;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.Min;

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
    @Min(value = 18,message = "未成年少女禁止入内")
    private Integer age;
}
