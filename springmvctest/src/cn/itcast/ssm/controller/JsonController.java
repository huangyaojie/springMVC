package cn.itcast.ssm.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.itcast.ssm.po.ItemsCustom;

@Controller
@RequestMapping("/json")
public class JsonController {
	@RequestMapping("/toJsonTest")
	public  String  jsonTest(){
		return "jsonTest";
	}
	@RequestMapping("/allJson")
	public  @ResponseBody ItemsCustom jsonTest0(@RequestBody ItemsCustom itemsCustom){
		itemsCustom.setItemName("allJson");
		return itemsCustom;
	}

	@RequestMapping("/responseJson")
	public  @ResponseBody ItemsCustom jsonTest1(HttpServletRequest request, ItemsCustom itemsCustom){
	String  itemName =	(String) request.getAttribute("itemName");
	Float itemPrice = (Float) request.getAttribute("itemPrice");
    String itemName1 = itemsCustom.getItemName();
    Float itemPrice1 = itemsCustom.getItemPrice();

    return itemsCustom;
	}


}
