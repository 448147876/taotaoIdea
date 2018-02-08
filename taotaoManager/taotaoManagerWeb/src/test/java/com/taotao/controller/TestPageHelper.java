package com.taotao.controller;

import com.alibaba.druid.pool.DruidDataSource;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.taotao.mapper.TbItemMapper;
import com.taotao.pojo.TbItem;
import com.taotao.pojo.TbItemExample;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.web.context.ContextLoader;
import org.springframework.web.context.WebApplicationContext;

import java.util.List;

public class TestPageHelper {
	private ApplicationContext applicationContext;

	@Before
	public void getApplicationContext(){
		//创建一个spring容器
		applicationContext = new ClassPathXmlApplicationContext("classpath:spring/applicationContext-*.xml");
	}
	@After
	public void closeApplicationContext(){
		System.out.printf("测试完成");


	}


	@Test
	public void testPageHelper() {

		//从spring容器中获得Mapper的代理对象
		TbItemMapper mapper = applicationContext.getBean(TbItemMapper.class);
		//执行查询，并分页
		TbItemExample example = new TbItemExample();
		//分页处理
		PageHelper.startPage(3, 10);
		List<TbItem> list = mapper.selectByExample(example);
		//取商品列表
		for (TbItem tbItem : list) {
			System.out.println(tbItem.getTitle());
		}
		//取分页信息
		PageInfo<TbItem> pageInfo = new PageInfo<>(list);
		long total = pageInfo.getTotal();
		System.out.println("共有商品："+ total);
	}

	@Test
	public void testDataSource(){
		DruidDataSource dataSource = (DruidDataSource) applicationContext.getBean("dataSource");
		System.out.printf(dataSource.toString());
	}


}
