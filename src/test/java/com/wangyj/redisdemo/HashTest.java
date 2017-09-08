package com.wangyj.redisdemo;

import com.wangyj.redisdemo.repository.HashRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class HashTest {

    @Autowired
    private HashRepository hashRepository;


    /**
     * 向has中添加field和其对应的值
     * @user wangyj
     * @date 2017/9/8 9:18
     * @param
     * @return
     */
    @Test
    public void add() throws Exception {

        hashRepository.add("phone","brand","Sumsang-S8");
        hashRepository.add("phone","price",6666.6);
    }


    /**
     * 判断hashkey是否存在
     * @user wangyj
     * @date 2017/9/8 9:41
     * @param
     * @return
     */
    @Test
    public void hasKey() throws Exception {

        boolean result = hashRepository.hasKey("phone","brand");
        System.err.println(result);

    }

    /**
     * 从键中的哈希获取给定hashKey的值
     * @user wangyj 
     * @date 2017/9/8 9:46
     * @param 
     * @return 
     */
    @Test
    public void getByKey() throws Exception {

        String result = (String) hashRepository.getByKey("phone","brand");
        System.err.println(result);

    }


    /**
     * 通过给定的delta增加散列hashKey的值（整型）
     * @user wangyj 
     * @date 2017/9/8 9:57
     * @param 
     * @return 
     */
    @Test
    public void increment(){
        hashRepository.increment("phone","price",1.0);
    }

}