package com.bdqn.service;

import java.util.List;

import com.bdqn.pojo.Items;

public interface ItemsService {
	public List<Items> list();

	public Items findItemsById(Integer id);

	public void saveItems(Items items);

}
