package com.wangyj.redisdemo;

import com.wangyj.redisdemo.repository.ListRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ListTest {

    @Autowired
    private ListRepository listRepository;

    @Test
    public void leftPush() throws Exception {
        listRepository.leftPush("programs","c++");
        listRepository.leftPush("programs","c");
        listRepository.leftPush("programs","java");
        listRepository.leftPush("programs","python");
    }


    /**
     * 将数组插入list
     * @user wangyj
     * @date 2017/9/7 10:28
     * @param
     * @return
     */
    @Test
    public void leftPushAll() throws Exception{
        String[] array= {"hello","world","!"};
        listRepository.leftPushAll("leftpushAll",array);

    }

    /**
     * 从存储在键中的列表中删除等于值的元素的第一个计数事件。
     * 计数参数以下列方式影响操作：
     * count> 0：删除等于从头到尾移动的值的元素。
     * count <0：删除等于从尾到头移动的值的元素。
     * count = 0：删除等于value的所有元素。
     * @user wangyj
     * @date 2017/9/7 11:10
     * @param
     * @return
     */
    @Test
    public void remove() throws Exception{
        listRepository.remove("leftpushAll",-1,"world");
    }


    @Test
    public void leftPop() throws Exception{
        listRepository.leftPop("leftpushAll");
    }

}