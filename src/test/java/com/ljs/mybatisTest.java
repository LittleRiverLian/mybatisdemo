package com.ljs;

import com.ljs.etl.bean.Classes;
import com.ljs.etl.bean.User;
import com.ljs.etl.mapper.ClassesMapper;
import com.ljs.etl.mapper.UserMapper;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.Date;
import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class) //使用Springtest测试框架
@ContextConfiguration("classpath:spring/applicationContext.xml")
public class mybatisTest {
    @Autowired  //注入
    private UserMapper userMapper;

    @Autowired  //注入
    private ClassesMapper classesMapper;

    @Autowired  //注入
    private SqlSessionFactory sqlSessionFactory;

    Logger logger = LoggerFactory.getLogger(mybatisTest.class);

    @Test
    public void save() {
        User user = new User();
        user.setBirthday(new Date());
        user.setName("marry");
        user.setSalary(300);
        userMapper.save(user);
        logger.info(user.getId() + "");
        while (true){}
    }

    @Test
    public void update() {
        User user = userMapper.findById(3);
        user.setSalary(2000);
        userMapper.update(user);
    }

    @Test
    public void delete() {
//        userMapper.delete(3);
        SqlSession session = sqlSessionFactory.openSession();

        String statement = "com.ljs.etl.mapper.UserMapper.delete";
        int insert = session.delete(statement, 5);
        //提交
        session.commit();

        session.close();

        logger.info(insert+"");
    }

    @Test
    public void findById() {
        User user = userMapper.findById(3);
        System.out.println(user);
    }

    @Test
    public void findAll() {
        List<User> users = userMapper.findAll();
        System.out.println(users);
    }

    //bean对象中关联另外一个对象
    @Test
    public void getClasses() {
        Classes classes = classesMapper.getClass(1);
        logger.info(classes.toString());
    }

}

