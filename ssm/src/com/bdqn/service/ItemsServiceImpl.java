package com.bdqn.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.bdqn.mapper.ItemsMapper;
import com.bdqn.pojo.Items;

@Service("itemsService")
public class ItemsServiceImpl implements ItemsService {
	@Resource(name = "itemsMapper")
	private ItemsMapper itemsMapper;

	@Override
	public List<Items> list() {
		List<Items> items = itemsMapper.findAllItems();
		return items;
	}

	@Override
	public Items findItemsById(Integer id) {
		Items items = itemsMapper.selectByPrimaryKey(id);
		return items;
	}

	@Override
	public void saveItems(Items items) {
		itemsMapper.updateByPrimaryKeyWithBLOBs(items);

	}

}
