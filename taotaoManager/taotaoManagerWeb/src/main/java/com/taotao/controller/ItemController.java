package com.taotao.controller;

import com.alibaba.druid.pool.DruidDataSource;
import com.taotao.common.utils.SpringContextUtils;
import com.taotao.common.pojo.EUDataGridResult;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import com.taotao.pojo.TbItem;
import com.taotao.service.ItemService;

import java.sql.Connection;

import java.sql.SQLException;

@Controller
@RequestMapping("/item")
public class ItemController {

	@Autowired
	private ItemService itemService;



	/**
	 * 进行post请求，接受参数为pojo
	 *
	 * @param tbItem
	 * @return
	 */
	@RequestMapping(value = "/itemId01", method = RequestMethod.POST)
	@ResponseBody
	public TbItem getItemById01(TbItem tbItem) {
		if (tbItem != null) {
			TbItem tbItemQry = itemService.getItemById(tbItem.getId());
			return tbItemQry;
		} else {
			return tbItem;
		}
	}

	/**
	 * 进行post请求，使用get方式，接收参数为商品id
	 *
	 * @param tbItemId
	 * @return
	 */
	@RequestMapping(value = "/itemId02", method = RequestMethod.GET)
	@ResponseBody
	public TbItem getItemById02(@RequestParam("itemId") Long tbItemId) {
		TbItem tbItemQry = itemService.getItemById(tbItemId);

		return tbItemQry;
	}





	/**
	 * 获取con的方法
	 * @return
	 * @throws SQLException
	 */
	@RequestMapping(value = "/test/ApplicationContext", method = RequestMethod.GET)
	public String testUrl() throws SQLException {
		ApplicationContext applicationContext = SpringContextUtils.getApplicationContext();
		//执行查询，并分页
		Connection con = null;
		DruidDataSource dataSource = (DruidDataSource) applicationContext.getBean("dataSource");

		Connection connection = dataSource.getConnection();

		return null;
	}

	/**
	 * 转发商品列表
	 * @return
	 */
	@RequestMapping(value ="/list",method = RequestMethod.GET)
	public String getItem() {
		/**
		 * 如果是list请求，则转发到index.jsp页面
		 */
		return "index";
	}

	@RequestMapping(value ="/children",method = RequestMethod.GET)
	public String getItemChile(String path) {
		/**
		 * 根据请求的类型，返回对应的页面
		 */
		return path;
	}

	/**
	 * 返回商品列表
	 * @return
	 */
	@RequestMapping(value ="/itemList",method = RequestMethod.GET)
	@ResponseBody
	public EUDataGridResult getItemList(Integer page, Integer rows) {
		EUDataGridResult result = itemService.getItemList(page, rows);

		return result;
	}


	/**
	 * 返回商品类别树
	 * @return
	 */
	@RequestMapping(value ="/cat",method = RequestMethod.POST)
	@ResponseBody
	public EUDataGridResult getItemCatTree(@RequestParam(value = "id",defaultValue = "0") Long parentId) {


		return null;
	}



}
