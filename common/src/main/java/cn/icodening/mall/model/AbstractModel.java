package cn.icodening.mall.model;

import lombok.Getter;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.util.Date;

/**
 * @author icodening
 * @date 2021.03.28
 */
@Getter
@Setter
@MappedSuperclass
public abstract class AbstractModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_")
    private Long id;

    @Column(name = "create_time", nullable = false)
    private Date createTime;

    @Column(name = "modify_time", nullable = false)
    private Date modifyTime;
}
