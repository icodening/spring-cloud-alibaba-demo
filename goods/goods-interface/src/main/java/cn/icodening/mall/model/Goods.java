package cn.icodening.mall.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * @author icodening
 * @date 2021.03.28
 */
@Getter
@Setter
@Entity
@Table(name = "goods")
public class Goods extends AbstractModel {

    private String name;

}
