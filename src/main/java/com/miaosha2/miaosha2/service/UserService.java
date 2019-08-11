package com.miaosha2.miaosha2.service;

import com.miaosha2.miaosha2.dao.UserDao;
import com.miaosha2.miaosha2.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author xyq
 * @date 2019/08/02
 */
@Service
public class UserService {

    @Autowired
    private UserDao userDao;

    public User getById(int id){
        return userDao.getById(id);
    }

    //@Transactional(rollbackFor = Exception.class)
    public boolean tx() {
        User u1 = new User();
        u1.setId(2);
        u1.setName("2222");
        userDao.insert(u1);

        User u2 = new User();
        u1.setId(1);
        u1.setName("11111");
        userDao.insert(u2);

        // 事务需要如下显示的抛出异常后才起作用
        if (true){
            throw new RuntimeException("插入异常");
        }
        return true;
    }
}
