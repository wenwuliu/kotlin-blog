package com.belphegor.common.mybatis;

import org.springframework.beans.factory.annotation.Autowired;

public abstract class BaseDAO<E,K extends BaseMapper<E>> {

    @Autowired
    protected K mapper;

    public int deleteByPrimaryKey(String id){
        return mapper.deleteByPrimaryKey(id);
    }

    public int insert(E record){
        return mapper.insert(record);
    }

    public int insertSelective(E record){
        return mapper.insertSelective(record);
    }

    public E selectByPrimaryKey(String id){
        return selectByPrimaryKey(id);
    }

    public int updateByPrimaryKeySelective(E record){
        return updateByPrimaryKeySelective(record);
    }

    public int updateByPrimaryKey(E record){
        return updateByPrimaryKey(record);
    }
}
