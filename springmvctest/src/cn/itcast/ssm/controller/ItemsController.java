package cn.itcast.ssm.controller;

import java.io.File;
import java.util.List;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import cn.itcast.ssm.exception.CustomException;
import cn.itcast.ssm.po.ItemsCustom;
import cn.itcast.ssm.po.ItemsQueryVo;
import cn.itcast.ssm.service.ItemsService;
import cn.itcast.ssm.validategroup.ValidateGroup2;
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
@Controller
//定义url的根路径，访问时根路径+方法的url
@RequestMapping("/items")
public class ItemsController {
	private static final Logger logger = LogManager.getLogger("ItemsController");

	//注入service
	@Autowired
	private ItemsService itemsService;
	//注入service
	@Autowired
	HttpServletRequest request; //这里可以获取到request
	@RequestMapping("/queryItems")
	public ModelAndView queryItems(HttpServletRequest request) throws Exception {
        //调用service查询商品列表
		List<ItemsCustom> itemsList = itemsService.findItemsList(null);
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.addObject("itemsList", itemsList);
		// 指定逻辑视图名
		modelAndView.setViewName("itemsList");
		return modelAndView;
	}
	@RequestMapping("/addItems")
	public ModelAndView addItems(HttpServletRequest request) throws Exception {
        logger.info("增加商品页面");
		ModelAndView modelAndView = new ModelAndView();
		// 指定逻辑视图名
		modelAndView.setViewName("addItems");
		return modelAndView;
	}
	@RequestMapping("/addItemsSubmit")
	public String  addItemsSubmit(Model model,MultipartFile itemPictureFile ,@ModelAttribute(value="itemsCustom") ItemsCustom itemsCustom) throws Exception {
        logger.info("增加商品提交（包括图片和商品信息）");
        if(null!=itemPictureFile){
    	   //变为双羊角号
    	   String  filePath = "D:\\virtualPics";
    	   String originalFilename = itemPictureFile.getOriginalFilename();
    	   String  newFilename= UUID.randomUUID()+originalFilename.substring(originalFilename.lastIndexOf("."));
    	    //存储到图片服务器的位置
    	   File file  =new  File(filePath+"\\"+newFilename);
    	   itemPictureFile.transferTo(file);
    	   itemsCustom.setItemBrand(newFilename);
    	   System.out.println("name"+itemsCustom.getItemName());
    	   System.out.println("price"+itemsCustom.getItemPrice());
    	   System.out.println("createtime"+itemsCustom.getItemCreateTime());
    	   System.out.println("detail"+itemsCustom.getItemDetail());
    	   System.out.println("brand"+itemsCustom.getItemBrand());

       }
        int n = itemsService.addItem(itemsCustom);
        System.out.println("ss"+n);
         if(n<=0){
	                throw new CustomException("添加失败");
           }else{
	                return "success";
           }
	}
	@RequestMapping("/queryItemByCond")
	public ModelAndView queryItemByCond(HttpServletRequest request) throws Exception {
        logger.info("查询商品页面");
		//调用service查询商品列表
		List<ItemsCustom> itemsList = itemsService.findItemsList(null);
		ModelAndView modelAndView = new ModelAndView();
		// 指定逻辑视图名
		modelAndView.setViewName("queryItem");
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
	     logger.info("/items/editItems:进入商品修改页面");
		//调用 service查询商品信息
		ItemsCustom itemsCustom = itemsService.findItemsById(id);
		model.addAttribute("ItemsCustom", itemsCustom);
		model.addAttribute("id",id);
		//返回jsp的名称，经过试图解析器找到该jsp.
		return "editItem_2";
	}
	//restfulTest
	@RequestMapping(value="/restfulTest/{id}",method={RequestMethod.GET})
	public @ResponseBody  ItemsCustom restfulTest(Model model,@PathVariable("id")  Integer id)throws Exception{

		//调用 service查询商品信息
		ItemsCustom itemsCustom = itemsService.findItemsById(id);
		return itemsCustom;
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
//		//调用 service查询商品信息
//		ItemsCustom itemsCustom = itemsService.findItemsById(id);
//		request.setAttribute("item", itemsCustom);
//		//注意如果使用request转向页面，这里指定页面的完整路径
//		request.getRequestDispatcher("/WEB-INF/jsp/editItem.jsp").forward(request, response);
//
//	}
	@RequestMapping("/deleteItems")
	public  ModelAndView deleteIds(Integer[] delete_id) throws Exception{
        logger.info("deleteItems:批量删除商品信息");
        //TODO
        //进行批量删除
		ModelAndView mv = new ModelAndView();
	    mv.addObject("message","删除成功");
		mv.setViewName("success");
		return mv;
	}
	//商品修改提交
    //itemsQueryVo是包装类型的pojo
	//@Validated(value={ValidateGroup2.class})，规定使用哪一组校验规则。
	@RequestMapping("/editItemSubmit")
	public String editItemSubmit(Model model,Integer id,@Validated(value={ValidateGroup2.class}) @ModelAttribute(value="ItemsCustom")ItemsCustom itemsCustom,BindingResult bindingResult) throws Exception{
      if(itemsCustom.getItemCreateTime()==null){
	        throw new CustomException("生产日期为null异常");
      }
		if(bindingResult.hasErrors()){
	 logger.info("商品修改后发现错误，显示错误的提示信息,并进行数据回显");
	List<ObjectError> allErrors = bindingResult.getAllErrors();
	model.addAttribute("errors",allErrors);
	model.addAttribute("id",id);
	model.addAttribute("ItemsCustom",itemsCustom);
	logger.info("商品修改后提发现错误");
	return "editItem_2";
   }else{
	      logger.info("商品修改后未发现错误，进行更新操作后，返回查询页面");
		   //调用service接口更新商品信息。得到执行结果的返回值。
	       int i =itemsService.updateItems(itemsCustom.getItemId(),itemsCustom);
	     /*  if(i==1){
	       //返回值为1，更新成功.
	       }else{
	    	//
	       }*/
		//请求重定向
        // return "redirect:queryItems.action";
	    //转发
	   	return "forward:queryItems.action";
     }
}
  //批量修改商品。绑定List<Object>
	@RequestMapping("/queryItemsToBatchUpdate")
	public String queryItemsToBatchUpdate(Model model ,Integer[] delete_id) throws Exception {
        logger.info("查询商品，进入批量更新页面");
        //TODO
        //根据传进的数组查询得到商品列表
        //调用service查询商品列表
		List<ItemsCustom> itemsList = itemsService.findItemsList(null);
		model.addAttribute("itemsList", itemsList);
		// 指定逻辑视图名
		return  "itemsListBatchUpdate";
	}
	//批量修改商品提交。绑定List<Object>
		@RequestMapping("/itemsListBatchUpdateSubmit")
		public String  queryItemsToBatchUpdateSubmit(Model model,ItemsQueryVo itemsQueryVo) throws Exception {
	        logger.info("批量更新商品列表");
	        //TODO
	        //根据传进的数组查询得到商品列表
        /*    List<ItemsCustom> itemsList = itemsQueryVo.getItemsList();
            int  i  =itemsList.size();
            model.addAttribute("message","aa"+i);*/
	        //调用service查询商品列表
			return "success";
		}

//自定义属性编辑器,字符串转化为日期Date类型。
//使用这种方法问题是无法在多个controller共用。
/*@InitBinder
public void initBinder(WebDataBinder binder) throws Exception {
	// Date.class必须是与controler方法形参pojo属性一致的date类型，这里是java.util.Date，不一致的无法绑定。
//}
	binder.registerCustomEditor(Date.class, new CustomDateEditor(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"), true));
}*/
}
