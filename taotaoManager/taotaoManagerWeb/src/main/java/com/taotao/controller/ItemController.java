package com.taotao.controller;

import com.taotao.mapper.TbItemMapper;
import com.taotao.pojo.TbItemExample;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.ResponseBody;

import com.taotao.pojo.TbItem;
import com.taotao.service.ItemService;

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

}
