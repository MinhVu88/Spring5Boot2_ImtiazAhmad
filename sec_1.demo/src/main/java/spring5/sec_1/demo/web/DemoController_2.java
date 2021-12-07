package spring5.sec_1.demo.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import spring5.sec_1.demo.domains.User;

@Controller
public class DemoController_2 {
	@RequestMapping("/")
	public String index(Model model) {
		model.addAttribute("userInfo", new User());
		return "index";
	}
	
	@RequestMapping(value = "/form", method = RequestMethod.POST)
	public String processFormData(User user, RedirectAttributes attr) {
		attr.addFlashAttribute("user", user);
		return "redirect:/form-data";
	}
	
	@RequestMapping(value = "/form-data", method = RequestMethod.GET)
	public String showFormData(User user) {
		return "user";
	}
}
