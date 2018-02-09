package com.taotao.controller;

import com.taotao.common.pojo.EUDataGridResult;
import com.taotao.common.pojo.EUTreeNode;
import com.taotao.pojo.TbItemCat;
import com.taotao.service.ItemCatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.LinkedList;
import java.util.List;


@Controller
@RequestMapping("/itemCat")
public class ItemCatController {


	@Autowired
	private ItemCatService itemCatService;


	/**
	 * 返回商品类别树
	 *
	 * @return
	 */
	@RequestMapping(value = "/cat", method = RequestMethod.POST)
	@ResponseBody
	public List<EUTreeNode> getItemCatTree(@RequestParam(value = "id", defaultValue = "0") Long parentId) {

		List<TbItemCat> list = itemCatService.selectByParentId(parentId);

		List<EUTreeNode> listTree = doSwitchTbItemCatToEUTreeNode(list);

		return listTree;
	}


	/**
	 * 将List<TbItemCat>转换为List<EUTreeNode>
	 *
	 * @param list
	 * @return
	 */
	private List<EUTreeNode> doSwitchTbItemCatToEUTreeNode(List<TbItemCat> list) {
		List<EUTreeNode> resultList = new LinkedList<EUTreeNode>();

		if (list != null && list.size() > 0) {
			for (TbItemCat tbItemCat :list) {
				EUTreeNode treeNode = new EUTreeNode();
				treeNode.setId(tbItemCat.getId());
				treeNode.setText(tbItemCat.getName());
				String child = tbItemCat.getIsParent()?"closed":"open";
				treeNode.setState(child);

				resultList.add(treeNode);


			}
		}
		return resultList;
	}


}
