package com.taotao.service.impl;

import com.taotao.mapper.TbItemCatMapper;
import com.taotao.mapper.TbItemMapper;
import com.taotao.pojo.TbItem;
import com.taotao.pojo.TbItemCat;
import com.taotao.service.ItemCatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class ItemCatServiceImpl implements ItemCatService {

	@Autowired
	private TbItemCatMapper tbItemCatMapper;


	@Override
	public List<TbItemCat> selectByParentId(Long parentId) {
		List<TbItemCat> list  =tbItemCatMapper.selectByParentId(parentId);
		return list;
	}
}
