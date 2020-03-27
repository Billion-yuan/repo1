package com.itheima.ssm.service;

import com.itheima.ssm.domain.Items;

import java.util.List;

public interface ItemsService {

    // 查询所有
    public List<Items> list();
    // 新增
    public int save(Items items);
}
