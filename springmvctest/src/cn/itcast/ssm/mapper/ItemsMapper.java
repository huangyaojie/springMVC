package cn.itcast.ssm.mapper;

import cn.itcast.ssm.po.Items;


public interface ItemsMapper {
 /*   int countByExample(ItemsExample example);

    int deleteByExample(ItemsExample example);
*//*
    int deleteByPrimaryKey(Integer id);

    int insert(Items record);

    int insertSelective(Items record);*/
/*
    List<Items> selectByExampleWithBLOBs(ItemsExample example);

    List<Items> selectByExample(ItemsExample example);*/
    //根据主键查询
    Items selectByPrimaryKey(Integer id);
    //根据主键修改
    int updateByPrimaryKeyWithBLOBs(Items record);
 /*   int updateByExampleSelective(@Param("record") Items record, @Param("example") ItemsExample example);

    int updateByExampleWithBLOBs(@Param("record") Items record, @Param("example") ItemsExample example);

    int updateByExample(@Param("record") Items record, @Param("example") ItemsExample example);
*/
/*    int updateByPrimaryKeySelective(Items record);
    int updateByPrimaryKeyWithBLOBs(Items record);

    int updateByPrimaryKey(Items record);*/
}