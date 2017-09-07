package com.wangyj.redisdemo;

import com.wangyj.redisdemo.repository.ListRepository;
import com.wangyj.redisdemo.repository.SetRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SetTest {

    @Autowired
    private SetRepository setRepository;

    /**
     * 向set种添加一个元素
     * @user wangyj
     * @date 2017/9/7 14:28
     * @param
     * @return
     */
    @Test
    public void add() throws Exception {

        Phone phone= new Phone();
        phone.setId("3");
        phone.setBrand("apple");
        setRepository.add("sets",phone);
    }

    /**
     * 判断一个元素是否在集合中
     * @user wangyj
     * @date 2017/9/7 14:31
     * @param
     * @return
     */
    @Test
    public void isMembers() throws Exception {
        Phone phone= new Phone();
        phone.setId("1");
        phone.setBrand("htc");
        boolean result = setRepository.isMembers("sets",phone);
        System.err.println(result);
    }

    /**
     * 移除一个或者多个元素
     * @user wangyj
     * @date 2017/9/7 14:46
     * @param
     * @return
     */
    @Test
    public void remove() throws Exception {
        Phone phone= new Phone();
        phone.setId("1");
        phone.setBrand("htc");
        setRepository.remove("sets",phone);
    }
}