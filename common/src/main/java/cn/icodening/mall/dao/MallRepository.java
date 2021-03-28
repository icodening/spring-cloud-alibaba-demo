package cn.icodening.mall.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.NoRepositoryBean;

/**
 * @author icodening
 * @date 2021.03.28
 */
@NoRepositoryBean
public interface MallRepository<T> extends JpaRepository<T, Long>,
        JpaSpecificationExecutor<T> {
}
