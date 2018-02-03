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
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.taotao.pojo.TbItem;
import com.taotao.service.ItemService;
import java.sql.Connection;

import javax.servlet.http.HttpServletRequest;
import java.sql.SQLException;
import java.util.List;

@Controller
public class ItemController {

	@Autowired
	private ItemService itemService;
	@Autowired
	private TbItemMapper itemMapper;
	
	@RequestMapping("/item/{itemId}")
	@ResponseBody
	public TbItem getItemById(@PathVariable Long itemId) {
		TbItem tbItem = itemService.getItemById(itemId);
//		TbItemExample example = new TbItemExample();
//		TbItemExample.Criteria criteria = example.createCriteria();
//		criteria.andIdEqualTo(itemId);
//		List<TbItem> list = itemMapper.selectByExample(example);
//		for(TbItem t:list){
//			return t;
//		}


		return tbItem;
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
