package cn.icodening.mall.service;

import java.util.List;

/**
 * @author icodening
 * @date 2021.03.28
 */
public interface IMallService<T> {

    List<T> findAll();

    void addRecord(T record);

    void updateRecord(T record);

    void save(T entity);

    void deleteById(Long id);

    void deleteByIds(List<Long> ids);

    T findById(Long id);
}
