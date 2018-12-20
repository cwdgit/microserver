package com.chinasofti.springcloud.dao;


import com.chinasofti.springcloud.entities.TbTransfer;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface OneToOneComparisonMapper {
    /**
     * 调用记录表中添加数据
     */
    int  addCallRecord (TbTransfer tbTransfer) throws Exception;
}