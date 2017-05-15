package cn.itcast.ssm.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import cn.itcast.ssm.po.ItemsCustom;
import cn.itcast.ssm.service.ItemsService;

/**
 *
 * <p>
 * Title: ItemsController
 * </p>
 * <p>
 * Description:商品管理
 * </p>
 * <p>
 * Company: www.itcast.com
 * </p>
 *
 * @author
 * @date 2015-3-20下午3:04:57
 * @version 1.0
 */
//
@Controller
//定义url的根路径，访问时根路径+方法的url
@RequestMapping("/items")
public class ItemsController {
	private final Logger log = LoggerFactory.getLogger(ItemsController .class);

	//注入service
	@Autowired
	private ItemsService itemsService;
	//注入service
	@Autowired
	HttpServletRequest request; //这里可以获取到request
	@RequestMapping("/queryItems")
	public ModelAndView queryItems(HttpServletRequest request) throws Exception {
     log.info("查询商品页面");

		//调用service查询商品列表
		List<ItemsCustom> itemsList = itemsService.findItemsList(null);

		ModelAndView modelAndView = new ModelAndView();
		modelAndView.addObject("itemsList", itemsList);
		// 指定逻辑视图名
		modelAndView.setViewName("itemsList");
		return modelAndView;
	}

	//商品修改页面显示
	//使用method=RequestMethod.GET限制使用get方法
/*	@RequestMapping(value="/editItems",method={RequestMethod.GET})
	public ModelAndView editItems()throws Exception{
       int id = Integer.parseInt(request.getParameter("id"));
		ModelAndView modelAndView = new ModelAndView();

		//调用 service查询商品信息
		ItemsCustom itemsCustom = itemsService.findItemsById(id);
	//将模型数据传到jsp
		modelAndView.addObject("item", itemsCustom);
		//指定逻辑视图名
	    modelAndView.setViewName("editItem");
		return modelAndView;

	}*/

	//方法返回 字符串，字符串就是逻辑视图名，Model作用是将数据填充到request域，在页面展示
	@RequestMapping(value="/editItems",method={RequestMethod.GET})
	public String editItems(Model model,Integer id)throws Exception{
	     log.info("进入商品修改页面");

		//调用 service查询商品信息
		ItemsCustom itemsCustom = itemsService.findItemsById(id);

		model.addAttribute("ItemsCustom", itemsCustom);

		model.addAttribute("id",id);

		return "editItem_2";


	}

	//方法返回void
//	@RequestMapping(value="/editItems",method={RequestMethod.GET})
//	public void editItems(
//			HttpServletRequest request,
//			HttpServletResponse response,
//			//@RequestParam(value = "item_id", required = false, defaultValue = "1") Integer id
//			Integer id
//			)
//			throws Exception {
//
//		//调用 service查询商品信息
//		ItemsCustom itemsCustom = itemsService.findItemsById(id);
//		request.setAttribute("item", itemsCustom);
//		//注意如果使用request转向页面，这里指定页面的完整路径
//		request.getRequestDispatcher("/WEB-INF/jsp/editItem.jsp").forward(request, response);
//
//	}

	@RequestMapping("/deleteIds")
	public  ModelAndView deleteIds(Integer[] delete_id) throws Exception{
		ModelAndView mv = new ModelAndView();
		mv.addObject("message","删除成功");
		mv.setViewName("success");
		return mv;
	}
	//商品修改提交
//	itemsQueryVo是包装类型的pojo
	@RequestMapping("/editItemSubmit")
	public String editItemSubmit(Model model,Integer id,@Validated @ModelAttribute(value="ItemsCustom")ItemsCustom itemsCustom,BindingResult bindingResult)throws Exception{
    if(bindingResult.hasErrors()){
	     log.info("商品修改提交");

	List<ObjectError> allErrors = bindingResult.getAllErrors();
	model.addAttribute("errors",allErrors);
	model.addAttribute("id",id);
	model.addAttribute("ItemsCustom",itemsCustom);
	return "editItem";
   }else{
		//调用service接口更新商品信息
		try {
			itemsService.updateItems(id, itemsCustom);
		} catch (Exception e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
		}
		//请求重定向
   //		return "redirect:queryItems.action";
}
		//转发
	return "forward:queryItems.action";
	}

	//自定义属性编辑器
//	@InitBinder
//	public void initBinder(WebDataBinder binder) throws Exception {
//		// Date.class必须是与controler方法形参pojo属性一致的date类型，这里是java.util.Date
//		binder.registerCustomEditor(Date.class, new CustomDateEditor(
//				new SimpleDateFormat("yyyy-MM-dd HH-mm-ss"), true));
//	}

}
