package com.ustbyjy.dao;

import com.ustbyjy.domain.User;
import org.springframework.data.repository.CrudRepository;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: Administrator
 * Date: 2017/3/10
 * Time: 10:50
 */
public interface DemoRepository extends CrudRepository<User, Long> {
}
