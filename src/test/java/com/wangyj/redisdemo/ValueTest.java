package com.wangyj.redisdemo;

import com.wangyj.redisdemo.repository.ValueRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.HashMap;
import java.util.Map;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ValueTest {

    @Autowired
    private ValueRepository userDao;

    @Test
    public void save() throws Exception {
        userDao.save("1","zz");
    }

    @Test
    public void getValue() throws Exception {
        System.err.println(userDao.getUser("1"));
    }

    @Test
    public void saveMulti() throws Exception {
        Map<String,String> map =new HashMap<>();
        map.put("2","wang2");
        map.put("3","wang3");
        map.put("4","wang4");
        userDao.saveMulti(map);
    }



}