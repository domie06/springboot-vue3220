package com.dao;

import com.entity.ManhuaEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.view.ManhuaView;

/**
 * 漫画 Dao 接口
 *
 * @author 
 */
public interface ManhuaDao extends BaseMapper<ManhuaEntity> {

   List<ManhuaView> selectListView(Pagination page,@Param("params")Map<String,Object> params);

}
