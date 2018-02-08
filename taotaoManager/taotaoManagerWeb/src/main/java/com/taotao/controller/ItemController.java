package com.taotao.controller;

import com.alibaba.druid.pool.DruidDataSource;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.taotao.common.SpringContextUtils;
import com.taotao.mapper.TbItemMapper;
import com.taotao.pojo.TbItemExample;
import org.apache.http.HttpRequest;

import org.mybatis.spring.SqlSessionFactoryBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import com.taotao.pojo.TbItem;
import com.taotao.service.ItemService;
import java.sql.Connection;

import java.sql.SQLException;
import java.util.List;

@Controller
@RequestMapping("/item")
public class ItemController {

	@Autowired
	private ItemService itemService;
	@Autowired
	private TbItemMapper itemMapper;


	/**
	 * 进行post请求，接受参数为pojo
	 * @param tbItem
	 * @return
	 */
	@RequestMapping(value = "/itemId01",method = RequestMethod.POST)
	@ResponseBody
	public TbItem getItemById01(TbItem tbItem) {
		if(tbItem != null){
			TbItem tbItemQry = itemService.getItemById(tbItem.getId());
			return tbItemQry;
		}else{
			return tbItem;
		}
	}

	/**
	 * 进行post请求，使用get方式，接收参数为商品id
	 * @param tbItemId
	 * @return
	 */
	@RequestMapping(value = "/itemId02",method = RequestMethod.GET)
	@ResponseBody
	public TbItem getItemById02(@RequestParam("itemId") Long tbItemId) {
			TbItem tbItemQry = itemService.getItemById(tbItemId);
			return tbItemQry;
	}

	/**
	 * 进行post请求，使用get方式，接收参数为商品id
	 * @param tbItemId
	 * @return
	 */
	@RequestMapping(value = "/itemId03",method = RequestMethod.POST)
	@ResponseBody
	public List<TbItem> getItemById03(Long tbItemId) {
		TbItemExample example = new TbItemExample();
		TbItemExample.Criteria criteria = example.createCriteria();
		criteria.andIdEqualTo(tbItemId);
		List<TbItem> list = itemMapper.selectByExample(example);

		return list;
	}


	@RequestMapping("/list")
	public String getItem(){
		return "index";
	}

	@RequestMapping("/{page}")
	public String getItemChile(@PathVariable String page){

		return page;
	}

	@RequestMapping(value = "/test/ApplicationContext",method = RequestMethod.GET)
	public String testUrl() throws SQLException {
		ApplicationContext applicationContext = SpringContextUtils.getApplicationContext();
		//执行查询，并分页
		Connection con = null;
		DruidDataSource dataSource = (DruidDataSource) applicationContext.getBean("dataSource");

		Connection connection = dataSource.getConnection();

		return null;
	}


}
