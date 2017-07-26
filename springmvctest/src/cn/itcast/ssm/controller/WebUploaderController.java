package cn.itcast.ssm.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;


/**webuploader
 * @author huangyaojie
 *
 */
@Controller
//定义url的根路径，访问时根路径+方法的url
@RequestMapping("/uploader")
public class WebUploaderController {
	@RequestMapping("/webUploaderCropper")
	public ModelAndView queryItems(HttpServletRequest request) throws Exception {
     ModelAndView modelAndView = new ModelAndView();
		// 指定逻辑视图名
		modelAndView.setViewName("cropper/webUploader");
		return modelAndView;
	}
 }
