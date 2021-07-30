package com.example.demo.service.impl;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.demo.dao.ProductDao;
import com.example.demo.entity.Product;
import com.example.demo.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

/**
 * @author qzz
 */
@Service("ProductService")
public class ProductServiceImpl implements ProductService {
    @Autowired
    private ProductDao productDao;


    /**
     * 添加商品信息
     * @param product
     * @return
     */
    @Override
    public int addProduct(Product product) {
        return productDao.insert(product);
    }

    /**
     * 编辑商品信息
     * @param product
     * @return
     */
    @Override
    public int updateProduct(Product product) {
        return productDao.updateById(product);
    }

    /**
     * 获取商品列表信息
     * @param queryWrapper
     * @return
     */
    @Override
    public List<Product> selectList(Wrapper<Product> queryWrapper) {
        return productDao.selectList(queryWrapper);
    }

    /**
     * 获取商品列表信息
     * @param queryWrapper
     * @return
     */
    @Override
    public List<Map<String, Object>> selectListMaps(Wrapper<Product> queryWrapper) {
        return productDao.selectMaps(queryWrapper);
    }

    /**
     * 分页获取商品列表信息
     * @return
     */
    @Override
    public IPage<Map<String,Object>> selectListByPage(Page page, Wrapper<Product> queryWrapper) {
        return productDao.selectMapsPage(page,queryWrapper);
    }

    /**
     * 批量删除商品
     * @param ids
     * @return
     */
    @Override
    public int deleteBatchProduct(Integer[] ids) {
        return productDao.deleteBatchIds(Arrays.asList(ids));
    }

    /**
     * 分页获取列表:执行自己编写的sql
     * @param page
     * @param product
     * @return
     */
    @Override
    public List<Map<String,Object>> getProductListByPage(Page page,Product product) {
        return productDao.getProductListByPage(page,product);
    }


}
