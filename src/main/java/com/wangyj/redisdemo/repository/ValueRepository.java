package com.wangyj.redisdemo.repository;


import java.util.Map; /**
 * 操作String类型数据
 * @user wangyj
 * @date 2017/9/6 15:29
 */
public interface ValueRepository {
    void save(String id, String name);

    String getUser(String id);


    void saveMulti(Map<String, String> map);
}
