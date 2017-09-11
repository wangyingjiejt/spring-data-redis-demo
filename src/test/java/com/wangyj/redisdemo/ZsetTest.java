package com.wangyj.redisdemo;

import com.wangyj.redisdemo.repository.SetRepository;
import com.wangyj.redisdemo.repository.ZsetRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ZsetTest {

    @Autowired
    private ZsetRepository zsetRepository;

    /**
     * 向Zset种添加一个有序集合
     * @user wangyj
     * @date 2017/9/7 14:28
     * @param
     * @return
     */
    @Test
    public void add() throws Exception {

        zsetRepository.add("phone","sumsang-s8",2.0);
        zsetRepository.add("phone","iphone7",1.9);
        zsetRepository.add("phone","mix2",1.6);

    }

    /**
     * 增加元素的score值，并返回增加后的值
     * @user wangyj
     * @date 2017/9/8 17:40
     */
    @Test
    public void incrementScore() throws Exception {
        zsetRepository.incrementScore("phone","mix2",1.6);

    }

    /**
     * 返回有序集中指定成员的排名（从0开始），其中有序集成员按分数值递减(从大到小)顺序排列
     * @user wangyj 
     * @date 2017/9/8 17:44
     */
    @Test
    public void reverseRank() throws Exception {
        zsetRepository.reverseRank("phone","iphone7");

    }


    /**
     * 通过索引区间返回有序集合成指定区间内的成员对象，其中有序集成员按分数值递增(从小到大)顺序排列
     * @user wangyj
     * @date 2017/9/8 17:51
     * @param
     * @return
     */
    @Test
    public void rangeWithScores(){
        zsetRepository.rangeWithScores("phone");
    }

    /**
     * 获取value值对应的score
     * @user wangyj
     * @date 2017/9/8 17:54
     * @param
     * @return
     */
    @Test
    public void getScore(){
        zsetRepository.getScore("phone","iphone7");
    }

}