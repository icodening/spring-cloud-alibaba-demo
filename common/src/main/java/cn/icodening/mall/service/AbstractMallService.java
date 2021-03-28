package cn.icodening.mall.service;

import cn.icodening.mall.dao.MallRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;

import java.util.List;
import java.util.Optional;

/**
 * @author icodening
 * @date 2021.03.28
 */
public abstract class AbstractMallService<T, R extends MallRepository<T>> implements IMallService<T> {
    @Autowired
    protected R repository;

    protected MallRepository<T> getRepository() {
        return this.repository;
    }


    @Override
    public List<T> findAll() {
        return getRepository().findAll();
    }

    @Override
    public void addRecord(T record) {

    }

    @Override
    public void updateRecord(T record) {

    }

    @Override
    public void save(T entity) {
        getRepository().save(entity);
    }

    @Override
    public void deleteById(Long id) {
        try {
            getRepository().deleteById(id);
        } catch (EmptyResultDataAccessException ignore) {
        }
    }

    @Override
    public void deleteByIds(List<Long> ids) {
        for (Long id : ids) {
            deleteById(id);
        }
    }

    @Override
    public T findById(Long id) {
        if (id == null) {
            return null;
        }
        Optional<T> optionalEntity = getRepository().findById(id);
        if (Optional.empty().equals(optionalEntity) || !optionalEntity.isPresent()) {
            return null;
        }
        return optionalEntity.get();
    }
}
