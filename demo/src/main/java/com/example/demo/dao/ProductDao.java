package com.example.demo.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.demo.entity.Product;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

/**
 * @author qzz
 */
@Repository
public interface ProductDao extends BaseMapper<Product> {

    /**
     * 分页获取列表:执行自己编写的sql
     * @param page
     * @param product
     * @return
     */
    List<Map<String,Object>> getProductListByPage(Page page, @Param("product") Product product);
}
