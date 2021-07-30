package com.example.demo.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.demo.entity.Product;
import com.example.demo.service.ProductService;
import com.example.demo.utils.PageData;
import com.example.demo.utils.Result;
import com.example.demo.utils.Tools;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import javax.servlet.http.HttpServletRequest;
import java.util.Date;
import java.util.List;
import java.util.Map;


/**
 * @author qzz
 */
@Api(tags = "商品管理API")
@RestController
@RequestMapping("/product")
public class ProductController {

    @Autowired
    private ProductService productService;


    /**
     * 分页获取商品列表
     */
    @GetMapping("/page")
    @ApiOperation("分页获取商品列表")
    public Result page(HttpServletRequest request){
        Page<Product> page = new Page<>(1,5);
        QueryWrapper<Product> queryWrapper = new QueryWrapper();
        //分页查看商品列表
        IPage<Map<String,Object>> pageInfo = productService.selectListByPage(page,queryWrapper);
        //返回结果集
        return new Result().ok(new PageData<>(pageInfo.getRecords(),pageInfo.getTotal()));
    }

    /**
     * 根据条件获取列表
     */
    @GetMapping("/list")
    @ApiOperation("根据条件获取列表")
    @ApiImplicitParams({
        @ApiImplicitParam(name = "title",value = "商品标题",paramType = "query",dataType = "String")
    })
    public Result getProductList(@RequestParam String title, HttpServletRequest request){
        QueryWrapper<Product> queryWrapper = new QueryWrapper();
        queryWrapper.like(Tools.notEmpty(title),"title",title);
        //此方法 sql有结果，但是返回数据除了title列，其他列都是null
        // List<Product> list = productService.selectList(queryWrapper);
        List<Map<String,Object>> list = productService.selectListMaps(queryWrapper);

        return new Result().ok(list);
    }

    /**
     * 添加商品信息
     */
    @PostMapping("add")
    @ApiOperation("添加商品信息")
    public Result addProduct(@RequestBody Product product){
        product.setCreate_by(1);
        product.setCreate_time(new Date());
        int n = productService.addProduct(product);
        if(n>0){
            return new Result().ok(product.getProduct_id());
        }else{
            return new Result().error(400,"添加商品失败");
        }
    }

    /**
     * 编辑商品信息
     */
    @PostMapping("update")
    @ApiOperation("编辑商品信息")
    public Result updateProduct(@RequestBody Product product){
        product.setUpdate_by(1);
        product.setUpdate_time(new Date());
        int n = productService.updateProduct(product);
        if(n>0){
            return new Result();
        }else{
            return new Result().error(400,"编辑商品失败");
        }
    }

    /**
     * 根据ids删除商品信息
     */
    @PostMapping("del")
    @ApiOperation("根据ids删除商品信息")
    public Result delProduct(@RequestBody Integer[] ids){
        int n = productService.deleteBatchProduct(ids);
        if(n>0){
            return new Result();
        }else{
            return new Result().error(400,"删除商品失败");
        }
    }

    /**
     * 分页获取商品列表:执行自己的sql
     * @param product  条件
     * @param currentPage 当前页
     * @param pageSize 每页个数
     * @return
     */
    @PostMapping("/productList")
    @ApiOperation("分页获取商品列表")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "currentPage",value = "当前页码",paramType = "query",dataType = "int"),
            @ApiImplicitParam(name = "pageSize",value = "每页显示个数",paramType = "query",dataType = "int")
    })
    public Result productList(@RequestBody Product product ,@RequestParam Integer currentPage,@RequestParam Integer pageSize){
        Page<Product> page = new Page<>(currentPage,pageSize);
        //分页查看商品列表
        List<Map<String,Object>> list = productService.getProductListByPage(page,product);
        //返回结果集
        return new Result().ok(new PageData<>(list,page.getTotal()));
    }

}
