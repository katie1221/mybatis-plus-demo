package com.example.demo.service;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.demo.entity.Product;
import java.util.List;
import java.util.Map;

/**
 * @author qzz
 */
public interface ProductService{


    /**
     * 添加商品信息
     * @param product
     * @return
     */
    int addProduct(Product product);

    /**
     * 编辑商品信息
     * @param product
     * @return
     */
    int updateProduct(Product product);

    /**
     * 获取商品列表信息
     * @param queryWrapper
     * @return
     */
    List<Product> selectList(Wrapper<Product> queryWrapper);

    /**
     * 获取商品列表信息
     * @param queryWrapper
     * @return
     */
    List<Map<String,Object>> selectListMaps(Wrapper<Product> queryWrapper);

    /**
     * 分页获取商品列表信息
     * @return
     */
    IPage<Map<String,Object>> selectListByPage(Page page, Wrapper<Product> queryWrapper);

    /**
     * 批量删除商品
     * @param ids
     * @return
     */
    int deleteBatchProduct(Integer[] ids);

    /**
     * 分页获取列表:执行自己编写的sql
     * @param page
     * @param product
     * @return
     */
    List<Map<String,Object>> getProductListByPage(Page page, Product product);
}
