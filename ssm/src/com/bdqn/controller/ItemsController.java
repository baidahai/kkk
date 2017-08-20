package com.bdqn.controller;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.bdqn.pojo.Items;
import com.bdqn.service.ItemsService;

@Controller
public class ItemsController {
	@Resource(name = "itemsService")
	private ItemsService itemsService;

	@RequestMapping("/list")
	public ModelAndView itemsList() {
		List<Items> list = itemsService.list();
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.addObject("itemList", list);
		modelAndView.setViewName("itemList");
		return modelAndView;

	}

	@RequestMapping("/itemEdit")
	public String itemEdit(HttpServletRequest request, Model model) {
		String idStr = request.getParameter("id");
		Items items = itemsService.findItemsById(Integer.parseInt(idStr));
		model.addAttribute("item", items);
		return "editItem";
	}

	@RequestMapping("/updateitem")
	public String update(Items items, Model model) {
		// items.setCreatetime(new Date());
		itemsService.saveItems(items);
		return "success";
	}

	@RequestMapping("/search")
	public String search(Items items, Model model) {

		return "itemList";
	}

	@RequestMapping("/delAll")
	public String delAll(Integer[] ids) {
		System.out.println(ids);
		return "";
	}
}
