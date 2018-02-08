package com.taotao.service;

import com.taotao.common.pojo.EUDataGridResult;
import com.taotao.pojo.TbItem;

import java.util.List;

public interface ItemService {

	TbItem getItemById(long itemId);

	/**
	 * 查询所有商品
	 * @return
	 * @param rows
	 * @param page
	 */
	EUDataGridResult getItemList(Integer rows, Integer page);
}
