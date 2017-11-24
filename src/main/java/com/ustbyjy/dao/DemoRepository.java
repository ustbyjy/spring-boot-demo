package com.ustbyjy.dao;

import com.ustbyjy.domain.Demo;
import org.springframework.data.repository.CrudRepository;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: Administrator
 * Date: 2017/3/10
 * Time: 10:50
 */
public interface DemoRepository extends CrudRepository<Demo, Long> {
}
